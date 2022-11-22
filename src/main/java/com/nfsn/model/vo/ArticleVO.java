package com.nfsn.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: ArticleVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:25
 * @Description: 文章响应实体
 */
@Data
@ApiModel("文章响应实体")
public class ArticleVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String introduction;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String articleContent;

    /**
     * 发表时间
     */
    @ApiModelProperty("发表时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 评论区
     */
    @ApiModelProperty("评论区")
    private List<ArticleCommentVO> comments;

    /**
     * 评论数
     */
    @ApiModelProperty("评论数")
    private Integer commentCount;

    /**
     * 点赞数(默认0)
     */
    @ApiModelProperty("点赞数")
    private Integer likeCount;

    /**
     * 收藏数(默认0)
     */
    @ApiModelProperty("收藏数")
    private Integer collectionCount;
}
