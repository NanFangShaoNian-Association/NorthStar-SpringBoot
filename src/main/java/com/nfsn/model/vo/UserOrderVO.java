package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserOrderVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 17:16
 * @Description: 用户订单详情响应实体
 */
@Data
@ApiModel("用户订单详情响应实体")
public class UserOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    private String title;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片——只传第一张")
    private String image;

    /**
     * 商品规格
     */
    @ApiModelProperty("商品规格")
    private String specification;

    /**
     * 商品单价
     */
    @ApiModelProperty("商品价格")
    private String price;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private String number;

    /**
     * 实际付款金额
     */
    @ApiModelProperty("实际付款金额")
    private String actualPaymentAmount;

    /**
     * 订单编号
     */
    @ApiModelProperty("订单编号")
    private String orderNo;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private String createTime;

    /**
     * 支付方式
     */
    @ApiModelProperty("支付方式")
    private String paymentWay;

    /**
     * 交易编号
     */
    @ApiModelProperty("交易编号")
    private String traceNo;

    /**
     * 物流最新一条状态（文字、时间）
     */
    @ApiModelProperty("物流最新一条状态（文字、时间）")
    private String logisticsStatus;

    /**
     * 快递公司logo
     */
    @ApiModelProperty("快递公司logo")
    private String expressCompanyLogo;

    /**
     * 订单状态（待付款、待发货、待收货、待评价）
     */
    @ApiModelProperty("订单状态（待付款、待发货、待收货、待评价）")
    private String status;
}
