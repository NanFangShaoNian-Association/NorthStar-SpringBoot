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
 * @TableName session
 */
@TableName(value ="session")
@Data
public class Session implements Serializable {
    /**
     * 会话ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户1ID
     */
    @TableField(value = "user1_id")
    private Integer user1Id;

    /**
     * 用户2ID
     */
    @TableField(value = "user2_id")
    private Integer user2Id;

    /**
     * 最后内容
     */
    @TableField(value = "last_content")
    private String lastContent;

    /**
     * 内容类型（0文本，1表情包，2图片，3视频）
     */
    @TableField(value = "last_content_type")
    private Integer lastContentType;

    /**
     * 最后时间
     */
    @TableField(value = "last_content_time")
    private Date lastContentTime;

    /**
     * 是否删除（0未删除，1已删除）
     */
    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}