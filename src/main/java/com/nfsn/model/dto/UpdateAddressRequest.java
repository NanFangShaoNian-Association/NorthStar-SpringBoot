package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UpdateAddressRequest
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 20:49
 * @Description: 更新地址信息响应实体
 */
@Data
@ApiModel("更新地址信息响应实体")
public class UpdateAddressRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID，此id为空视为新增地址，否则为修改地址
     */
    @ApiModelProperty("id，此id为空视为新增地址，否则为修改地址")
    private Integer id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 收件人
     */
    @ApiModelProperty("收件人")
    private String receiver;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phoneNumber;

    /**
     * 所在地区（省、市、区），填写示例：广东省-广州市-黄埔区
     */
    @ApiModelProperty("所在地区（省、市、区），填写示例：广东省-广州市-黄埔区")
    private String place;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String address;

    /**
     * 是否为默认地址
     */
    @ApiModelProperty("是否为默认地址")
    private Boolean isDefault;
}
