package com.nfsn.model.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName goods
 */
@TableName(value ="goods")
@Data
public class Goods implements Serializable {
    /**
     * 商品ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商家ID
     */
    @TableField(value = "merchant_id")
    private Integer merchantId;

    /**
     * 商品类型ID
     */
    @TableField(value = "merchant_type_id")
    private Integer merchantTypeId;

    /**
     * 商品信息ID
     */
    @TableField(value = "merchant_info_id")
    private Integer merchantInfoId;

    /**
     * 商品标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 简介
     */
    @TableField(value = "introducation")
    private String introducation;

    /**
     * 价格
     */
    @TableField(value = "price")
    private Integer price;

    /**
     * 商品库存
     */
    @TableField(value = "goods_stocks")
    private Integer goodsStocks;

    /**
     * 商品总数量
     */
    @TableField(value = "total_quantity")
    private Integer totalQuantity;

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