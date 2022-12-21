package com.nfsn.model.entity;



import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName friend
 */
@TableName(value ="friend")
@Data
public class Friend implements Serializable {
    /**
     * 好友id
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 用户1id
     */
    @TableField(value = "user1_id")
    private Integer user1Id;

    /**
     * 用户2id
     */
    @TableField(value = "user2_id")
    private Integer user2Id;

    /**
     * 状态（0待通过，1已通过，2已删除）
     */
    @TableField(value = "status")
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}