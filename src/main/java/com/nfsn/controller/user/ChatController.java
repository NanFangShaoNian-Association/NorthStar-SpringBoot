package com.nfsn.controller.user;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nfsn.common.Message;
import com.nfsn.common.RedisMessageData;
import com.nfsn.constants.RedisConstants;
import com.nfsn.convertor.MessageDecoder;
import com.nfsn.convertor.MessageEncoder;
import com.nfsn.model.entity.Friend;
import com.nfsn.model.entity.User;
import com.nfsn.service.FriendService;
import com.nfsn.service.UserService;
import com.nfsn.utils.CacheClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: atnibamaitay
 * @Date: 2022/12/11 20:33
 * @Description: 使用websocket实现聊天功能
 * 前端需要先调用onOpen建立连接，然后给后端传发送消息的用户id、接收消息的用户id和消息即可实现通讯
 * 目前存在问题
 * 1、只能在双方同时连接webstocket时才能通讯，因为消息没有经过数据库或redis，如果另一方不在线，即使上线了也无法收到消息
 */

@ServerEndpoint(value = "/ws/{userId}", decoders = {MessageDecoder.class}, encoders = {MessageEncoder.class})
@Component
@Slf4j
public class ChatController {

    //用来记录fromUserId和该session进行绑定
    private static final Map<Integer, Session> map = new ConcurrentHashMap<>();

    //用来存放每个客户端对应的MyWebSocket对象
    private static final Map<Integer, ChatController> webSocketSet = new ConcurrentHashMap<>();

    private List<Integer> friendIds;

    private static UserService userService;

    private static FriendService friendService;

    private static CacheClient cacheClient;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setFriendService(FriendService friendService) {
        this.friendService = friendService;
    }

    @Autowired
    public void setCacheClient(CacheClient cacheClient) {
        this.cacheClient = cacheClient;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Integer userId) {
        log.info("user:{}已连接",userId);
        map.put(userId, session);

        //加入set中
        webSocketSet.put(userId, this);
    }

    /**
     * 关闭连接调用的方法
     */
    @OnClose
    public void onClose(@PathParam("userId") Integer userId) {
        //从map中删除
        webSocketSet.remove(userId);
        map.remove(userId);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 当前session连接
     */
    @OnMessage
    public void onMessage(Message message, Session session) {
        //接收到来自fromId的消息，首先进行校验用户是否存在
        if (!checkUserIsExist(message)) {
            //无效操作，不再继续操作
            return;
        }
        //判断用户操作——消息类型："apply-friend"申请好友，"friend-message"：好友消息，"delete-friend：""删除好友"
        switch (message.getType()) {
            case "apply-friend":
                //校验是否为好友关系
                if (checkFriend(message)) {
                    //已经是好友了，无需继续操作
                    log.info("已经是好友了，无需继续操作");
                    return;
                }
                applyFriend(message);
                break;
            case "friend-message":
                //校验是否为好友关系
                if (!checkFriend(message)) {
                    //无效操作，不再继续操作
                    return;
                }
                friendMessage(message);
                break;
            case "delete-friend":
                //校验是否为好友关系
                if (!checkFriend(message)) {
                    //无效操作，不再继续操作
                    return;
                }
                deleteFriend(message);
                break;
            default:
                break;
        }

    }

    private void applyFriend(Message message) {
        Friend friend = new Friend();

        friend.setUser1Id(Integer.valueOf(message.getFromId()));
        friend.setUser2Id(Integer.valueOf(message.getToId()));
        friend.setStatus(0);

        friendService.save(friend);
    }

    private void deleteFriend(Message message) {
        friendService.remove(new LambdaQueryWrapper<Friend>()
                .eq(Friend::getUser1Id, message.getFromId()).eq(Friend::getUser2Id, message.getToId())
                .or()
                .eq(Friend::getUser1Id, message.getToId()).eq(Friend::getUser2Id, message.getFromId()));
    }

    private void friendMessage(Message message) {
        // 判断用户是否处于在线状态
        if (webSocketSet.get(Integer.valueOf(message.getToId())) != null) {
            // 1.在线存入redis，发送
            storeData(message, 0);
            send(message);
        } else {
            // 2.离线存入redis，并标记未发送
            storeData(message, 1);
        }
    }


    private void send(Message message) {
        try {
            Session session = map.get(Integer.valueOf(message.getToId()));
            session.getBasicRemote().sendObject(message);
        } catch (IOException e) {
            log.error("send发送异常");
            e.printStackTrace();
        } catch (EncodeException e) {
            log.error("send转化异常");
            e.printStackTrace();
        }
    }

    private void storeData(Message message, int onlineStatus) {
        RedisMessageData messageData = BeanUtil.copyProperties(message, RedisMessageData.class);
        messageData.setIsAck(onlineStatus);

        friendIds.stream().forEach(friendId -> {
            cacheClient.listRightPush(RedisConstants.FRIEND_MESSAGE_KEY+friendId, JSONUtil.toJsonStr(messageData));
        });
    }

    public boolean check(Message message) {
        // 1.校验两用户是否存在
        if (!checkUserIsExist(message)){
            return false;
        }
        // 2.校验是否互为好友关系
        if (!checkFriend(message)){
            return false;
        }
        return true;
    }

    public boolean checkUserIsExist(Message message) {
        // 1.校验两用户是否存在
        long count = userService.count(new LambdaQueryWrapper<User>().eq(User::getId, message.getFromId()).or().eq(User::getId, message.getToId()));
        if (count != 2) {
            //无效操作
            log.error("无效操作：当前用户或发送用户不存在");
            return false;
        }
        return true;
    }

    public boolean checkFriend(Message message) {
        // 2.校验是否互为好友关系
//        Friend friend = friendService.getOne(new LambdaQueryWrapper<Friend>()
//                .and(chain -> chain.eq(Friend::getUser1Id, message.getFromId()).eq(Friend::getUser2Id, message.getToId()))
//                .or()
//                .and(chain -> chain.eq(Friend::getUser1Id, message.getToId()).eq(Friend::getUser2Id, message.getFromId())));

        Friend friend = friendService.getOne(new LambdaQueryWrapper<Friend>()
                .eq(Friend::getUser1Id, message.getFromId()).eq(Friend::getUser2Id, message.getToId())
                .or()
                .eq(Friend::getUser1Id, message.getToId()).eq(Friend::getUser2Id, message.getFromId()));

        if (friend == null) {
            //无效操作
            log.error("无效操作：当前用户和发送用户不是好友");
            return false;
        }
        friendIds = new ArrayList<>();
        friendIds.add(friend.getId());
        return true;
    }
    /**
     * 发生错误时调用
     *
     * @param error
     */
    @OnError
    public void onError(Throwable error) {
        error.printStackTrace();
    }

}