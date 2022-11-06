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
 * @TableName merchant_comment
 */
@TableName(value ="merchant_comment")
@Data
public class MerchantComment implements Serializable {
    /**
     * 商品评价ID
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 评论者ID
     */
    @TableField(value = "reviewer_id")
    private Integer reviewerId;

    /**
     * 回复者ID
     */
    @TableField(value = "replier_id")
    private Integer replierId;

    /**
     * 内容类型（0文本，1表情包，2图片）
     */
    @TableField(value = "type")
    private Integer type;

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