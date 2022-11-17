package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: ArticleListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:24
 * @Description: 文章列表响应实体
 */
@Data
@ApiModel("文章列表响应实体")
public class ArticleListVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 文章ID
     */
    @ApiModelProperty("文章ID")
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
