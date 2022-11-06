package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: UserGoodListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/03 23:02
 * @Description: 用户浏览商品列表响应实体
 */
@Data
@ApiModel("用户浏览商品列表响应实体")
public class UserGoodListVO implements Serializable {
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
     * 付款人数
     */
    @ApiModelProperty("付款人数")
    private String paymentCount;

}
