package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserOrderListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 17:17
 * @Description: 用户订单列表响应实体
 */
@Data
@ApiModel("用户订单列表响应实体")
public class UserOrderListVO implements Serializable {
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
     * 商品价格
     */
    @ApiModelProperty("商品价格")
    private String price;

    /**
     * 商品数量
     */
    @ApiModelProperty("商品数量")
    private String number;

    /**
     * 交易状态（交易成功、已退货、已取消订单）
     */
    @ApiModelProperty("交易状态（交易成功、已退货、已取消订单）")
    private String status;


}
