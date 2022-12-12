package com.nfsn.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: PetsListVO
 * @Author: 团子tz
 * @CreateTime: 2022/11/21 12:18
 * @Description: 宠物列表响应实体
 */
@Data
@ApiModel("宠物列表响应实体")
public class PetsListVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 宠物ID
     */
    @ApiModelProperty("宠物ID")
    private Integer id;

    /**
     * 宠物品种
     */
    @ApiModelProperty("宠物品种")
    private String petVariety;

    /**
     * 宠物名
     */
    @ApiModelProperty("宠物名")
    private String nickName;

    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    private Integer birthday;

    /**
     * 照片
     */
    @ApiModelProperty("照片")
    private String avatar;

    /**
     * 性别（公、母）
     */
    @ApiModelProperty("性别（公、母）")
    private String gender;

    /**
     * 绝育情况
     */
    @ApiModelProperty("绝育情况")
    private String sterilizationStatus;

    /**
     * 驱虫情况
     */
    @ApiModelProperty("驱虫情况")
    private String insectRepellentStatus;

    /**
     * 疫苗情况
     */
    @ApiModelProperty("疫苗情况")
    private String vaccineStatus;

}
