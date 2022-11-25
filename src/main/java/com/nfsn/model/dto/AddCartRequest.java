package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: AddCartRequest
 * @Author: AtnibamAitay
 * @CreateTime: 2022/11/24 19:58
 * @Description: 增添到购物车实体
 */
@Data
@ApiModel("增添到购物车实体")
public class AddCartRequest  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户id")
    private Integer userId;

    /**
     * 商品ID
     */
    @ApiModelProperty("商品ID")
    private Integer goodsId;
}
