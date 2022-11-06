package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: LoginRequest
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 08:58
 * @Description: 登录传输实体
 */
@Data
@ApiModel("用户登录传输实体")
public class LoginRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;

    /**
     * 验证码
     */
    @ApiModelProperty("验证码")
    private String verifyCode;

    /**
     * 登陆时间
     */
    @ApiModelProperty("登陆时间")
    private Date loginTime;

    /**
     * 角色（用户手机号0，用户微信1，用户QQ登录2，商家3，平台管理员4），默认为0
     */
    @ApiModelProperty("角色（用户手机号0，用户微信1，用户QQ登录2，商家3，平台管理员4），默认为0")
    private Integer roleId = 0;
}
