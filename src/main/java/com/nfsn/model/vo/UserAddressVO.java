package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserOrderListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 17:17
 * @Description: 用户地址响应实体
 */
@Data
@ApiModel("用户地址响应实体")
public class UserAddressVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

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
     * 省ID
     */
    @ApiModelProperty("省ID")
    private Integer provinceId;

    /**
     * 市ID
     */
    @ApiModelProperty("市ID")
    private Integer cityId;

    /**
     * 区ID
     */
    @ApiModelProperty("区ID")
    private Integer regionId;

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
