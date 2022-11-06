package com.nfsn.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName discount_coupon
 */
@TableName(value ="discount_coupon")
@Data
public class DiscountCoupon implements Serializable {
    /**
     * 优惠券ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 优惠券金额
     */
    @TableField(value = "price")
    private Integer price;

    /**
     * 优惠券使用条件
     */
    @TableField(value = "conditions")
    private String conditions;

    /**
     * 优惠券名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 有效期
     */
    @TableField(value = "expiration_date")
    private String expirationDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}