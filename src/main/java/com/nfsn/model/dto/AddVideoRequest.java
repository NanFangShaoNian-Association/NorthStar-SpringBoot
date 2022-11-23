package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: AddVideoRequest
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:48
 * @Description: 发布视频传输实体
 */
@Data
@ApiModel("发布视频传输实体")
public class AddVideoRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 视频url（只能一个）
     */
    @ApiModelProperty("视频url（只能一个）")
    private String videoUrl;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;

    /**
     * 封面
     */
    @ApiModelProperty("封面")
    private String coverUrl;

}
