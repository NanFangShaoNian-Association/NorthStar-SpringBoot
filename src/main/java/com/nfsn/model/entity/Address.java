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
 * @TableName address
 */
@TableName(value ="address")
@Data
public class Address implements Serializable {
    /**
     * 地址ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 省ID
     */
    @TableField(value = "province_id")
    private Integer provinceId;

    /**
     * 市ID
     */
    @TableField(value = "city_id")
    private Integer cityId;

    /**
     * 区ID
     */
    @TableField(value = "region_id")
    private Integer regionId;

    /**
     * 详细地址
     */
    @TableField(value = "detail_address")
    private String detailAddress;

    /**
     * 是否删除（0未删除，1已删除）
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 是否默认（0否，1默认）
     */
    @TableField(value = "is_default")
    private Integer isDefault;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}