package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: GoodsVO
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 14:37
 * @Description: 商品列表响应实体
 */
@Data
@ApiModel("商品列表响应实体")
public class GoodListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    private String title;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片——只传第一张")
    private String image;
}
