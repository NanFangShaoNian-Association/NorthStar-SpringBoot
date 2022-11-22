package com.nfsn.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
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
     * 图片列表（1-5张）
     */
    @ApiModelProperty("图片列表（1-5张）")
    private List<String> imagesUrl;

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
     * 封面，文章图片总共限制六张，第一张作为封面
     */
    @ApiModelProperty("封面，文章图片总共限制六张，第一张作为封面")
    private String coverUrl;


}
