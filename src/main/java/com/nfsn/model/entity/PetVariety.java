package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName pet_variety
 */
@TableName(value ="pet_variety")
@Data
public class PetVariety implements Serializable {
    /**
     * 宠物品种ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 宠物品种名
     */
    @TableField(value = "pet_variety_name")
    private String petVarietyName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}