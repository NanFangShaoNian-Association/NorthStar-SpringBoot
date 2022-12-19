package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.FriendMapper;
import com.nfsn.model.entity.Friend;
import com.nfsn.service.FriendService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【friend】的数据库操作Service实现
* @createDate 2022-12-19 20:35:38
*/
@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend>
    implements FriendService {

}




