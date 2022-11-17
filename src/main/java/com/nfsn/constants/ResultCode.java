package com.nfsn.constants;

//状态码枚举
public enum ResultCode {
    /*成功状态码*/
    SUCCESS(1,"成功"),
    /*参数错误：1001-1999*/
    PARAM_IS_INVALID(1001,"参数无效"),
    PARAM_IS_BLANK(1002,"参数为空"),
    PARAM_TYPE_BIND_ERROR(1003,"参数类型错误"),
    PARAM_NOT_COMPLETE(1004,"参数缺失"),
    /*用户错误：2001-2999*/
    USER_NOT_LOGGED_IN(2001,"用户未登录，访问的路径需要验证，请登录"),
    USER_LOGIN_ERROR(2002,"账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(2003,"账号已被禁用"),
    USER_NOT_EXIST(2004,"用户不存在"),
    USER_HAS_EXISTED(2005,"用户已存在"),
    USER_TOKEN_IS_INVALID(2006,"用户token无效"),
    USER_TOKEN_IS_BLANK(2007,"用户token为空"),
    USER_VERIFY_ERROR(2008,"验证码校验失败，请重新获取"),
    USER_ARTICLE_PUBLISH_FAIL(2009,"用户文章发布失败，请检查是否含有违规信息"),
    /*服务器内部错误*/
    INTERNAL_ERROR(5001,"服务器内部错误");

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 接口调用提示信息
     */
    private String message;

    ResultCode(Integer code, String message){
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