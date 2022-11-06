package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserDiscountCouponListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:05
 * @Description: 用户所拥有优惠券列表响应实体
 */
@Data
@ApiModel("用户所拥有优惠券列表响应实体")
public class UserDiscountCouponListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 优惠券ID
     */
    @ApiModelProperty("优惠券ID")
    private Integer id;

    /**
     * 优惠券金额
     */
    @ApiModelProperty("优惠券金额")
    private Integer price;

    /**
     * 优惠券使用条件
     */
    @ApiModelProperty("优惠券使用条件")
    private String conditions;

    /**
     * 优惠券名
     */
    @ApiModelProperty("优惠券名")
    private String name;

    /**
     * 有效期
     */
    @ApiModelProperty("有效期")
    private String expirationDate;
}
