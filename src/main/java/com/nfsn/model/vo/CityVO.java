package com.nfsn.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("市响应实体")
public class CityVO  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 市ID
     */
    @ApiModelProperty("市ID")
    private Integer id;

    /**
     * 省ID
     */
    @ApiModelProperty("省ID")
    private Integer provinceId;

    /**
     * 市名
     */
    @ApiModelProperty("市名")
    private String cityName;
}