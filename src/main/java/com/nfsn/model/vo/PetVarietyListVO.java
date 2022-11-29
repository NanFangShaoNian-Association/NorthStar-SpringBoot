package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: PetVarietyListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/27 22:22
 * @Description: 宠物品种列表响应实体
 */
@Data
@ApiModel("宠物品种列表响应实体")
public class PetVarietyListVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 宠物品种ID
     */
    @ApiModelProperty("宠物品种ID")
    private Integer id;

    /**
     * 宠物品种名
     */
    @ApiModelProperty("宠物品种名")
    private String petVarietyName;

}
