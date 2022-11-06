package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserOrderListRequest
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 00:56
 * @Description: 订单商品列表传输实体
 */
@Data
@ApiModel("订单商品列表传输实体")
public class UserOrderListRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Integer id;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private Integer count;

    /**
     * 商品单价
     */
    @ApiModelProperty("商品单价")
    private Integer price;
}
