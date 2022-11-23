package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: UserOrderRequest
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 00:41
 * @Description: 创建订单传输实体
 */
@Data
@ApiModel("创建订单传输实体")
public class UserOrderRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 收货地址id
     */
    @ApiModelProperty("收货地址id")
    private Integer addressId;

    /**
     * 订单商品列表
     */
    @ApiModelProperty("订单商品列表")
    private List<UserOrderListRequest> orders;

    /**
     * 配送服务（快递、免邮）
     */
    @ApiModelProperty("配送服务（快递、免邮）")
    private String deliveryService;

    /**
     * 订单备注
     */
    @ApiModelProperty("订单备注")
    private String orderMark;

//    /**
//     * 商品总价
//     */
//    @ApiModelProperty("商品总价")
//    private Integer totalPrice;

    /**
     * 优惠券id（如果使用就填上）
     */
    @ApiModelProperty("优惠券id（如果使用就填上）")
    private Integer discountCouponId;

//    /**
//     * 商品实际金额
//     */
//    @ApiModelProperty("商品实际金额")
//    private Integer actualPrice;

    /**
     * 支付方式（支付宝0，微信1）
     */
    @ApiModelProperty("支付方式（支付宝0，微信1）")
    private Integer payment;

}
