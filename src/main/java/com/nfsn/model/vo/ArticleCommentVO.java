package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: ArticleCommentVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:41
 * @Description: 文章评论响应实体
 */
@Data
@ApiModel("文章评论响应实体")
public class ArticleCommentVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 评论者ID
     */
    @ApiModelProperty("评论者ID")
    private Integer reviewerId;

//    /**
//     * 回复者ID
//     */
//    @ApiModelProperty("回复者ID")
//    private Integer replierId;
//
//    /**
//     * 内容类型（0文本，1表情包，2图片）
//     */
//    @ApiModelProperty("内容类型（0文本，1表情包，2图片）")
//    private Integer type;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
}
