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
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名，随机生成
     */
    @TableField(value = "user_name")
    private String userName;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 性别（男，女，未指定）
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 简介
     */
    @TableField(value = "introduction")
    private String introduction;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 地区
     */
    @TableField(value = "place")
    private String place;

    /**
     * 最后一次登陆的IP
     */
    @TableField(value = "last_login_ip")
    private String lastLoginIp;

    /**
     * 最后一次登陆的IP属地
     */
    @TableField(value = "last_login_ip_place")
    private String lastLoginIpPlace;

    /**
     * 注册时间
     */
    @TableField(value = "registration_time")
    private Date registrationTime;

    /**
     * 最后一次登录时间
     */
    @TableField(value = "login_time")
    private Date loginTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}