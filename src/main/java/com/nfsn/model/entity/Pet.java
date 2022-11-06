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
 * @TableName pet
 */
@TableName(value ="pet")
@Data
public class Pet implements Serializable {
    /**
     * 宠物ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 主人ID
     */
    @TableField(value = "master_id")
    private Integer masterId;

    /**
     * 宠物品种ID
     */
    @TableField(value = "pet_variety_id")
    private Integer petVarietyId;

    /**
     * 宠物名
     */
    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 照片
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 性别（GG，MM，绝育GG，绝育MM，未指定）
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 生物类型（喵星人、汪星人、其他）
     */
    @TableField(value = "type")
    private String type;

    /**
     * 绝育情况
     */
    @TableField(value = "sterilization_status")
    private String sterilizationStatus;

    /**
     * 驱虫情况
     */
    @TableField(value = "insect_repellent_status")
    private String insectRepellentStatus;

    /**
     * 疫苗情况
     */
    @TableField(value = "vaccine_status")
    private String vaccineStatus;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}