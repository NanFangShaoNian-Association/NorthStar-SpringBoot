package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: CreateOrderRequest
 * @Author: 团子tz
 * @CreateTime: 2022/11/26 21:10
 * @Description: 查询订单传输实体
 */
@Data
@ApiModel("查询订单传输实体")
public class QueryOrderRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
    @ApiModelProperty("订单ID")
    String orderId;
}
