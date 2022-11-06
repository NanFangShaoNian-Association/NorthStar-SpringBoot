package com.nfsn.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: OperateUserRequest
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 20:16
 * @Description: 用户管理传输实体
 */
@Data
@ApiModel("用户管理传输实体")
public class OperateUserRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 需要操作的用户id
     */
    @ApiModelProperty("需要操作的用户id")
    private Integer userId;

    /**
     * 角色（用户0，商家1，平台管理员2）
     */
    @ApiModelProperty("角色（用户0，商家1，平台管理员2）")
    private Integer roleId;

    /**
     * 操作码（注销0，封号,1，解冻2）
     */
    @ApiModelProperty("操作码（注销0，封号,1，解冻2）")
    private Integer operationCode;
}
