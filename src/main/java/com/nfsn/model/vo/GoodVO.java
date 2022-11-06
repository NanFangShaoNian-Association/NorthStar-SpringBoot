package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: GoodVO
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 14:46
 * @Description: 商品详情响应实体
 */
@Data
@ApiModel("商品详情响应实体")
public class GoodVO implements Serializable {
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
     * 商品图片列表
     */
    @ApiModelProperty("商品图片列表")
    private List<String> images;

    /**
     * 商品信息--具体内容
     */
    @ApiModelProperty("商品信息--具体内容")
    private String merchantInfoDetailContent;

    /**
     * 简介
     */
    @ApiModelProperty("简介")
    private String introducation;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private Integer price;

    /**
     * 商品库存
     */
    @ApiModelProperty("商品库存")
    private Integer goodsStocks;

    /**
     * 商品总数量
     */
    @ApiModelProperty("商品总数量")
    private Integer totalQuantity;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
}
