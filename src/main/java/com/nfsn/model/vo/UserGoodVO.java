package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: UserGoodVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/03 23:09
 * @Description: 用户浏览商品详情响应实体
 */
@Data
@ApiModel("用户浏览商品详情响应实体")
public class UserGoodVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 商品详情响应实体
     */
    @ApiModelProperty("商品详情响应实体")
    private GoodVO good;

    /**
     * 商品评论响应实体
     */
    private List<GoodCommentVO> goodComment;

}
