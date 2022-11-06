package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: CartItemVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/02 00:08
 * @Description: 购物车商品项响应实体
 */
@Data
@ApiModel("购物车商品项响应实体")
public class CartItemVO implements Serializable {
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


    /**
     * 商品规格
     */
    @ApiModelProperty("商品规格")
    private String specification;


    /**
     * 单价
     */
    @ApiModelProperty("商品单价")
    private String price;

    /**
     * 选择数量
     */
    @ApiModelProperty("选择数量")
    private String number;



}
