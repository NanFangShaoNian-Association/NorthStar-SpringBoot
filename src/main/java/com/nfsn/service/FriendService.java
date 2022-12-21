package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.Friend;
import com.nfsn.model.vo.UserListVO;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【friend】的数据库操作Service
* @createDate 2022-12-19 20:35:38
*/
public interface FriendService extends IService<Friend> {

    List<UserListVO> listFriend();
}