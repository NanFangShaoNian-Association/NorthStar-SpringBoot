package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.User;

import java.util.Date;

/**
* @author Tuanzi
* @description 针对表【user】的数据库操作Service
* @createDate 2022-11-03 22:17:40
*/
public interface UserService extends IService<User> {

    /**
     * 根据用户手机号查询用户
     * @param phone 手机号
     * @return 用户信息
     */
    User getUserByPhone(String phone, Date loginTime);

    String getUserNameById(Integer userId);
}
