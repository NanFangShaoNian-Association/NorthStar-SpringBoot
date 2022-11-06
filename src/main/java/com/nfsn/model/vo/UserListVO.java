package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 21:31
 * @Description: 用户列表响应实体
 */
@Data
@ApiModel("用户列表响应实体")
public class UserListVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private Integer userName;

    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 性别（男，女，未指定）
     */
    @ApiModelProperty("性别（男，女，未指定）")
    private String gender;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String introduction;
}
