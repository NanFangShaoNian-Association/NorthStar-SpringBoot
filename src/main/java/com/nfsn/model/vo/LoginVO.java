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
}
