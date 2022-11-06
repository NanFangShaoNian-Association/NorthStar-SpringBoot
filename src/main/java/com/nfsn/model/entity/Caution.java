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
 * @TableName caution
 */
@TableName(value ="caution")
@Data
public class Caution implements Serializable {
    /**
     * 提醒ID
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

    /**
     * 提醒间隔（秒）
     */
    @TableField(value = "caution_duration")
    private Integer cautionDuration;

    /**
     * 是否完成（0未完成，1已完成）
     */
    @TableField(value = "finished")
    private Integer finished;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}