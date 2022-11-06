package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName province
 */
@TableName(value ="province")
@Data
public class Province implements Serializable {
    /**
     * 省ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 省名
     */
    @TableField(value = "province_name")
    private String provinceName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}