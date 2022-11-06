package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName merchant
 */
@TableName(value ="merchant")
@Data
public class Merchant implements Serializable {
    /**
     * 商家ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名，随机生成
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 注册时间
     */
    @TableField(value = "registration_time")
    private Date registrationTime;

    /**
     * 登录时间
     */
    @TableField(value = "login_time")
    private Date loginTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}