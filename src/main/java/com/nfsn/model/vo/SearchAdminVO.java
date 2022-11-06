package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName: SearchAdminVO
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 21:00
 * @Description: 平台管理端搜索用户响应实体
 */
@Data
@ApiModel("平台管理端搜索用户响应实体")
public class SearchAdminVO extends SearchUserVO{
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 注册时间
     */
    @ApiModelProperty("注册时间")
    private Date registrationTime;

    /**
     * 最后登录时间
     */
    @ApiModelProperty("登录时间")
    private Date loginTime;

    /**
     * 最后登录ip
     */
    @ApiModelProperty("最后登录ip")
    private String loginIp;

    /**
     * 最后登录ip属地
     */
    @ApiModelProperty("最后登录ip属地")
    private String loginIpPlace;

    /**
     * 状态（正常0、封号1）
     */
    @ApiModelProperty("状态（正常0、封号1）")
    private Integer status;
}
