package com.nfsn.model.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName merchant_info
 */
@TableName(value ="merchant_info")
@Data
public class MerchantInfo implements Serializable {
    /**
     * 商品信息ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 具体内容
     */
    @TableField(value = "detail_content")
    private String detailContent;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}