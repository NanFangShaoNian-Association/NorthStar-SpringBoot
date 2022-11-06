package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: SearchRequest
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 20:44
 * @Description: 通用搜索传输实体
 */
@Data
@ApiModel("通用搜索传输实体")
public class SearchRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 根据用户id搜索
     */
    @ApiModelProperty("根据用户id搜索")
    private Integer userId;

    /**
     * 根据用户名搜索
     */
    @ApiModelProperty("根据用户名搜索")
    private Integer userName;

    /**
     * 根据手机号搜索
     */
    @ApiModelProperty("根据手机号搜索")
    private Integer phone;

    /**
     * 每一页记录的数目，默认10条
     */
    @ApiModelProperty("每一页记录的数目，默认10条")
    private Integer size = 10;

    /**
     * 当前用户所在页码，默认为1
     */
    @ApiModelProperty("前用户所在页码，默认为1")
    private Integer current = 1;
}
