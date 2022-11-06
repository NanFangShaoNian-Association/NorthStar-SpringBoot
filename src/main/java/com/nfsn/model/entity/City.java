package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName city
 */
@TableName(value ="city")
@Data
public class City implements Serializable {
    /**
     * 市ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 省ID
     */
    @TableField(value = "province_id")
    private Integer provinceId;

    /**
     * 市名
     */
    @TableField(value = "city_name")
    private String cityName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}