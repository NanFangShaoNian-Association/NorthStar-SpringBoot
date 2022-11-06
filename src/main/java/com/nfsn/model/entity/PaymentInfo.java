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
 * @TableName payment_info
 */
@TableName(value ="payment_info")
@Data
public class PaymentInfo implements Serializable {
    /**
     * 支付记录ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 订单ID
     */
    @TableField(value = "order_info_id")
    private Integer orderInfoId;

    /**
     * 支付系统交易编号
     */
    @TableField(value = "transaction_no")
    private String transactionNo;

    /**
     * 支付类型
     */
    @TableField(value = "payment_type")
    private String paymentType;

    /**
     * 交易类型
     */
    @TableField(value = "trade_type")
    private String tradeType;

    /**
     * 交易状态
     */
    @TableField(value = "trade_state")
    private String tradeState;

    /**
     * 支付金额
     */
    @TableField(value = "payer_total")
    private Integer payerTotal;

    /**
     * 通知参数
     */
    @TableField(value = "content")
    private String content;

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