package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.UserMapper;
import com.nfsn.model.entity.User;
import com.nfsn.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




