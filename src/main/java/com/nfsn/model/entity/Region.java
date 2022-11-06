package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName region
 */
@TableName(value ="region")
@Data
public class Region implements Serializable {
    /**
     * 区ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 市ID
     */
    @TableField(value = "city_id")
    private Integer cityId;

    /**
     * 区名
     */
    @TableField(value = "region")
    private String region;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}