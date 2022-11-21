package com.nfsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.UserMapper;
import com.nfsn.model.entity.User;
import com.nfsn.model.entity.Video;
import com.nfsn.service.UserService;
import com.nfsn.utils.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据用户手机号查询用户
     * @param phone 手机号
     * @return 用户信息
     */
    @Override
    public User getUserByPhone(String phone, Date loginTime) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone, phone);
        User user = this.getOne(queryWrapper);

        if (user == null) {
            User insertUser = new User();
            insertUser.setUserName(getRandomName());
            insertUser.setPhone(phone);
            insertUser.setAvatar(getDefaultAvatar());
            insertUser.setGender(getDefaultGender());
            insertUser.setIntroduction(getDefaultIntroduction());
            insertUser.setRegistrationTime(loginTime);

            this.save(insertUser);

            user = this.getOne(queryWrapper);
        }

        return user;
    }

    /**
     * 通过用户ID获取用户名
     * @param userId
     * @return
     */
    @Override
    public String getUserNameById(Integer userId) {
        User user = userMapper.selectById(userId);

        if (user == null){
            return null;
        }

        return user.getUserName();
    }

    private String getRandomName(){
        return "ns_" + RandomUtils.getRandom(RandomUtils.ALL_LITTLE_LETTER,13);
    }

    private String getDefaultAvatar(){
        return "https://upload-bbs.mihoyo.com/upload/2021/04/26/275717452/3101bce2626a6c808e975e7d4514958e_4697878850710672732.jpg";
    }

    private String getDefaultGender(){
        return "男";
    }

    private String getDefaultIntroduction(){
        return "您还没有简介，请添加简介！";
    }
}




