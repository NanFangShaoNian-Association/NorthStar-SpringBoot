package com.nfsn.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName refund_info
 */
@TableName(value ="refund_info")
@Data
public class RefundInfo implements Serializable {
    /**
     * 退款单ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单ID
     */
    @TableField(value = "order_info_id")
    private Integer orderInfoId;

    /**
     * 商户退款单ID
     */
    @TableField(value = "refund_order_info_id")
    private Integer refundOrderInfoId;

    /**
     * 支付系统退款单号
     */
    @TableField(value = "refund_no")
    private String refundNo;

    /**
     * 原订单金额（分）
     */
    @TableField(value = "total_fee")
    private Integer totalFee;

    /**
     * 退款金额（分）
     */
    @TableField(value = "refund")
    private Integer refund;

    /**
     * 退款原因
     */
    @TableField(value = "reason")
    private String reason;

    /**
     * 退款状态
     */
    @TableField(value = "refund_status")
    private String refundStatus;

    /**
     * 申请退款返回参数
     */
    @TableField(value = "content_return")
    private String contentReturn;

    /**
     * 退款结果通知参数
     */
    @TableField(value = "content_notify")
    private String contentNotify;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}