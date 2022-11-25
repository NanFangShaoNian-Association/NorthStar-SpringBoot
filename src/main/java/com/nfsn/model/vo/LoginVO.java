package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: LoginVO
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 14:32
 * @Description: 登录响应实体
 */
@Data
@ApiModel("用户登录响应实体")
public class LoginVO implements Serializable{
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * token
     */
    @ApiModelProperty("用户登录令牌")
    private String token;

    /**
     * 角色（用户手机号0，商家3，平台管理员4），默认为0
     */
    @ApiModelProperty("角色（用户手机号0，商家3，平台管理员4），默认为0")
    private Integer roleId = 0;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String introduction;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 关注数
     */
    @ApiModelProperty("关注数")
    private Integer followNumber = 0;

    /**
     * 粉丝数
     */
    @ApiModelProperty("粉丝数")
    private Integer fansNumber = 0;
}
