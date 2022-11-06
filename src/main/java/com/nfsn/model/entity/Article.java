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
 * @TableName article
 */
@TableName(value ="article")
@Data
public class Article implements Serializable {
    /**
     * 文章ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 位置信息ID
     */
    @TableField(value = "location_info_id")
    private Integer locationInfoId;

    /**
     * 文章url
     */
    @TableField(value = "article_url")
    private String articleUrl;

    /**
     * 内容
     */
    @TableField(value = "article_content")
    private String articleContent;

    /**
     * 发表时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 封面
     */
    @TableField(value = "cover_url")
    private String coverUrl;

    /**
     * 点赞数(默认0)
     */
    @TableField(value = "like_count")
    private Integer likeCount;

    /**
     * 收藏数(默认0)
     */
    @TableField(value = "collection_count")
    private Integer collectionCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}