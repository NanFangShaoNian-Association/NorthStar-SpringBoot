package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: GoodTypeVO
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 15:04
 * @Description: 商品类型响应实体
 */
@Data
@ApiModel("商品类型响应实体")
public class GoodTypeVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品类型ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 类型
     */
    @ApiModelProperty("type")
    private String type;
}
