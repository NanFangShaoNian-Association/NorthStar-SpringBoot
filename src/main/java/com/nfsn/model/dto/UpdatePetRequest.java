package com.nfsn.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UpdatePetRequest
 * @Author: 团子tz
 * @CreateTime: 2022/11/21 12:32
 * @Description: 编辑/新增宠物信息请求实体
 */
@Data
@ApiModel("编辑、新增宠物信息请求实体")
public class UpdatePetRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 宠物ID
     */
    @ApiModelProperty("宠物ID")
    private Integer id;

    /**
     * 宠物品种
     */
    @ApiModelProperty("宠物品种ID")
    private Integer petVarietyId;

    /**
     * 宠物名
     */
    @ApiModelProperty("宠物名")
    private String nickName;

    /**
     * 生日
     */
    @ApiModelProperty("年龄，按出生年月日算：示例2012-03-24")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;

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
     * 生物类型（喵星人、汪星人、其他）
     */
    @ApiModelProperty("生物类型（喵星人、汪星人、其他）")
    private String type;

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
