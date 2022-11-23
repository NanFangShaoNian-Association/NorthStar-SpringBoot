package com.nfsn.model.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName cart_goods
 */
@TableName(value ="cart_goods")
@Data
public class CartGoods implements Serializable {
    /**
     * 购物车商品ID
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
     * 商品数量
     */
    @TableField(value = "goods_quantity")
    private Integer goodsQuantity;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}