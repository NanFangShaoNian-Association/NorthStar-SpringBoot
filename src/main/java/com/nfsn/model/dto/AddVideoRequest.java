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
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;

    /**
     * 视频url（只能一个）
     */
    @ApiModelProperty("视频url（只能一个）")
    private String videoUrl;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String videoContent;

}
