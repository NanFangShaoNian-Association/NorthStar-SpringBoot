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
 * @TableName health_info
 */
@TableName(value ="health_info")
@Data
public class HealthInfo implements Serializable {
    /**
     * 健康记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宠物ID
     */
    @TableField(value = "pet_id")
    private Integer petId;

    /**
     * 类型
     */
    @TableField(value = "type")
    private String type;

    /**
     * 时间
     */
    @TableField(value = "time")
    private Date time;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}