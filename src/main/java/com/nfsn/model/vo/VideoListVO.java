package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: VideoListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:25
 * @Description: 视频列表响应实体
 */
@Data
@ApiModel("视频列表响应实体")
public class VideoListVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 视频ID
     */
    @ApiModelProperty("视频ID")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String userName;

    /**
     * 封面
     */
    @ApiModelProperty("封面")
    private String coverUrl;

    /**
     * 内容（截取一段，两行）
     */
    @ApiModelProperty("内容")
    private String articleContent;

    /**
     * 点赞数
     */
    @ApiModelProperty("点赞数")
    private Integer likeCount;
}
