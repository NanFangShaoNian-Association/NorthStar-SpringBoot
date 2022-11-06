package com.nfsn.model.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user_follow
 */
@TableName(value ="user_follow")
@Data
public class UserFollow implements Serializable {
    /**
     * 关注ID
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 博主ID
     */
    @TableField(value = "blogger_id")
    private Integer bloggerId;

    /**
     * 粉丝ID
     */
    @TableField(value = "fans_id")
    private Integer fansId;

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