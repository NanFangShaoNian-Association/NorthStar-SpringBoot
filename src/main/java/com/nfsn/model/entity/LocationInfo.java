package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName location_info
 */
@TableName(value ="location_info")
@Data
public class LocationInfo implements Serializable {
    /**
     * 位置信息ID
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * IP地址
     */
    @TableField(value = "ip_address")
    private String ipAddress;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}