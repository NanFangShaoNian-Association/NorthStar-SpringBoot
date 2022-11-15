package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: AddArticleRequest
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:48
 * @Description: 发布文章传输实体
 */
@Data
@ApiModel("发布文章传输实体")
public class AddArticleRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;

    /**
     * 图片列表（1-6张）
     */
    @ApiModelProperty("图片列表（1-6张）")
    private List<String> imagesUrl;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String articleContent;

}