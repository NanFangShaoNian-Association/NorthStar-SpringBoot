package com.nfsn.constants;

/**
 * @ClassName: OrderStatus
 * @Author: 团子tz
 * @CreateTime: 2022/11/27 00:42
 * @Description: 订单状态
 */
public enum OrderStatus {
    WAITING_PAID(0,"待支付"),
    WAITING_SHIPPED(1,"待发货"),
    SHIPPED(2,"已发货"),
    WAITING_RECEIVING(3,"待收货"),
    FINISH(4,"已完成"),
    REFUND(5,"待退款");
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 接口调用提示信息
     */
    private String description;

    OrderStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
