package com.nfsn.model.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName merchant_images
 */
@TableName(value ="merchant_images")
@Data
public class MerchantImages implements Serializable {
    /**
     * 商品图片ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品ID
     */
    @TableField(value = "merchant_id")
    private Integer merchantId;

    /**
     * 图片
     */
    @TableField(value = "image_url")
    private String imageUrl;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}