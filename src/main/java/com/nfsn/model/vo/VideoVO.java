package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: VideoVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:25
 * @Description: 视频响应实体
 */
@Data
@ApiModel("视频响应实体")
public class VideoVO implements Serializable {
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
    private Date createTime;

    /**
     * 评论区
     */
    @ApiModelProperty("评论区")
    private List<VideoCommentVO> comments;

    /**
     * 评论数
     */
    @ApiModelProperty("评论数")
    private Integer commentCount;

}
