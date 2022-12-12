package com.nfsn.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ChatRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 发送者id
     */
    @ApiModelProperty("发送消息者的用户id")
    private int fromUserId;

    /**
     * 接受者id
     */
    @ApiModelProperty("接收消息者的用户id")
    private int toUserId;

    /**
     * 消息
     */
    @ApiModelProperty("消息")
    private String msg;
}