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
 * @TableName message_info
 */
@TableName(value ="message_info")
@Data
public class MessageInfo implements Serializable {
    /**
     * 消息记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发送者ID
     */
    @TableField(value = "sender_id")
    private Integer senderId;

    /**
     * 接受者ID
     */
    @TableField(value = "receiver_id")
    private Integer receiverId;

    /**
     * 内容类型（0文本，1表情包，2图片，3视频）
     */
    @TableField(value = "content_type")
    private Integer contentType;

    /**
     * 内容
     */
    @TableField(value = "content")
    private String content;

    /**
     * 是否删除（0未删除，1已删除）
     */
    @TableField(value = "deleted")
    private Integer deleted;

    /**
     * 是否已读（0未读，1已读）
     */
    @TableField(value = "is_read")
    private Integer isRead;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}