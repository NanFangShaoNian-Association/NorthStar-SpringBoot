package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: CartVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/02 00:05
 * @Description: 购物车响应实体
 */
@Data
@ApiModel("购物车响应实体")
public class CartVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 购物车商品项
     */
    @ApiModelProperty("购物车商品项")
    private List<CartItemVO> items;

    /**
     * 合计金额
     */
    @ApiModelProperty("合计金额")
    private String totalPrice;

}
