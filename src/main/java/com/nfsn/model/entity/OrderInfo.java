package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName order_info
 */
@TableName(value ="order_info")
@Data
@NoArgsConstructor
public class OrderInfo implements Serializable {
    /**
     * 订单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 商品ID
     */
    @TableField(value = "goods_id")
    private Integer goodsId;

    /**
     * 商家ID
     */
    @TableField(value = "merchant_id")
    private Integer merchantId;

    /**
     * 发货地址ID
     */
    @TableField(value = "ship_address_id")
    private Integer shipAddressId;

    /**
     * 商户订单编号
     */
    @TableField(value = "order_no")
    private Integer orderNo;

    /**
     * 订单标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 订单金额（分）
     */
    @TableField(value = "total_fee")
    private Integer totalFee;

    /**
     * 订单二维码链接
     */
    @TableField(value = "code_url")
    private String codeUrl;

    /**
     * 订单状态（0待支付，1待发货，2已发货，3待收货，4已完成，5待退款）
     */
    @TableField(value = "order_status")
    private Integer orderStatus;

    /**
     * 订单备注
     */
    @TableField(value = "order_remark")
    private String orderRemark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}