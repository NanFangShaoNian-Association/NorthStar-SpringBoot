package com.nfsn.constants;

/**
 * @ClassName: PaymentConstans
 * @Author: 团子tz
 * @CreateTime: 2022/11/26 16:40
 * @Description: 支付常量
 */
public enum PaymentConstants {
    /*todo：支付常量定义*/
    SUCCESS(1,"成功");





    /**
     * 状态码
     */
    private Integer code;
    /**
     * 接口调用提示信息
     */
    private String message;

    PaymentConstants(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
