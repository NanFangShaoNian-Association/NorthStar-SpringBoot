package com.nfsn.controller.user;

import com.nfsn.model.dto.ChatRequest;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Auther: atnibamaitay
 * @Date: 2022/12/11 20:33
 * @Description: 使用websocket实现聊天功能
 * 前端需要先调用onOpen建立连接，然后给后端传发送消息的用户id、接收消息的用户id和消息即可实现通讯
 * 目前存在问题
 * 1、只能在双方同时连接webstocket时才能通讯，因为消息没有经过数据库或redis，如果另一方不在线，即使上线了也无法收到消息
 */

@ServerEndpoint(value = "/sendMsg/{fromUserId}")
@Component
public class ChatController {

    //用来记录fromUserId和该session进行绑定
    private static final Map<Integer, Session> map = new HashMap<Integer, Session>();

    //用来存放每个客户端对应的MyWebSocket对象
    private static final CopyOnWriteArraySet<ChatController> webSocketSet = new CopyOnWriteArraySet<ChatController>();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("fromUserId") Integer fromUserId) {

        map.put(fromUserId, session);

        //加入set中
        webSocketSet.add(this);
    }

    /**
     * 关闭连接调用的方法
     */
    @OnClose
    public void onClose() {
        //从set中删除
        webSocketSet.remove(this);
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message    客户端发送过来的消息
     * @param fromUserId
     */
    @OnMessage
    public void onMessage(String message, @PathParam("fromUserId") Integer fromUserId) {

        // 从客户端传过来的数据是json数据，所以这里使用jackson进行转换为SocketMsg对象，
        ObjectMapper objectMapper = new ObjectMapper();
        ChatRequest chatRequest;

        try {
            chatRequest = objectMapper.readValue(message, ChatRequest.class);

            //先找到发送者
            chatRequest.setFromUserId(fromUserId);

            Session fromSession = map.get(chatRequest.getFromUserId());
            Session toSession = map.get(chatRequest.getToUserId());

            //发送给接受者
            if (toSession != null) {
                //发送给发送者
                fromSession.getAsyncRemote().sendText(chatRequest.getMsg());
                toSession.getAsyncRemote().sendText(chatRequest.getMsg());
            } else {
                //如果用户id不存在，或者是消息接收者的用户id不在线时。
                fromSession.getAsyncRemote().sendText("对方不在线或者用户已注销。");
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

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