package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserException;
import com.nfsn.mapper.FriendMapper;
import com.nfsn.model.entity.Friend;
import com.nfsn.model.entity.User;
import com.nfsn.model.vo.UserListVO;
import com.nfsn.service.FriendService;
import com.nfsn.service.UserService;
import com.nfsn.utils.AccountHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Tuanzi
* @description 针对表【friend】的数据库操作Service实现
* @createDate 2022-12-19 20:35:38
*/
@Service
@Slf4j
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
    implements FriendService {
    @Resource
    private UserService userService;

    @Override
    public List<UserListVO> listFriend() {
        Integer userId = AccountHolder.getUser().getId();
        //获取好友表中所有已通过验证的好友
        List<Friend> friendList = this.list(new LambdaQueryWrapper<Friend>()
                .eq(Friend::getUser1Id, userId)
                .or()
                .eq(Friend::getUser2Id, userId)
                .and(friendLambdaQueryWrapper -> friendLambdaQueryWrapper.eq(Friend::getStatus, 1)));

        //映射所有的id
        if (friendList.size() == 0){
            throw new UserException(ResultCode.PARAM_IS_INVALID);
        }
        List<Integer> friendIds = friendList.stream()
                .filter(friend -> !friend.getUser1Id().equals(friend.getUser2Id()))//过滤除自己之外的好友
                .map(friend -> friend.getUser1Id().equals(userId) ? friend.getUser2Id() : friend.getUser1Id())//获取好友id
                .collect(Collectors.toList());

        log.info("friendIds：{}",friendIds);
        //获取好友对应的信息
        List<User> userList = userService.listByIds(friendIds);

        List<UserListVO> userListVOS = BeanUtil.copyToList(userList, UserListVO.class);
        return userListVOS;
    }
}




