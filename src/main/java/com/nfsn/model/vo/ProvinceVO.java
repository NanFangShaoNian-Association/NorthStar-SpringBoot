package com.nfsn.model.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel("省响应实体")
public class ProvinceVO  implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 省ID
     */
    @ApiModelProperty("省ID")
    private Integer id;

    /**
     * 省名
     */
    @ApiModelProperty("省名")
    private String provinceName;

}