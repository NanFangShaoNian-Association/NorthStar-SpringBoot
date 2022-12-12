package com.nfsn.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("区响应实体")
public class RegionVO  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 区ID
     */
    @ApiModelProperty("区ID")
    private Integer id;

    /**
     * 市ID
     */
    @ApiModelProperty("市ID")
    private Integer cityId;

    /**
     * 区名
     */
    @ApiModelProperty("区名")
    private String region;
}