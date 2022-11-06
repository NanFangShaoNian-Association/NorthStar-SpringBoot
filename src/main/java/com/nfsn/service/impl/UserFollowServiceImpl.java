package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.UserFollowMapper;
import com.nfsn.model.entity.UserFollow;
import com.nfsn.service.UserFollowService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【user_follow】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class UserFollowServiceImpl extends ServiceImpl<UserFollowMapper, UserFollow>
implements UserFollowService{

}
