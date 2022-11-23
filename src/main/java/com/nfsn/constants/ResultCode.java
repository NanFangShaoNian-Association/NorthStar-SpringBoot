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
    USER_ARTICLE_DELETE_FAIL(2010,"用户文章删除失败，此操作为非法操作"),
    USER_ARTICLE_NOT_EXISTED(2011,"用户文章不存在"),
    USER_COLLECTION_HAS_EXISTED(2012,"用户已收藏，请勿重复操作"),
    USER_COLLECTION_NOT_EXISTED(2013,"用户尚未收藏，请勿重复此操作"),
    USER_COLLECTION_FAIL(2014,"用户收藏操作失败，请检查此操作是否合法"),
    USER_PET_NOT_EXISTED(2015,"该宠物不存在"),
    USER_PET_VARIETY_NOT_EXISTED(2016,"宠物品种不存在"),
    USER_VIDEO_PUBLISH_FAIL(2017,"用户视频发布失败，请检查是否含有违规信息"),
    USER_VIDEO_DELETE_FAIL(2018,"用户视频删除失败，此操作为非法操作"),
    USER_VIDEO_NOT_EXISTED(2019,"用户视频不存在"),
    /*服务器内部错误*/
    INTERNAL_ERROR(5001,"服务器内部错误，请联系开发人员"),
    PARAMETER_CONVERSION_ERROR(5002,"参数转换错误，请检查您发送的参数是否合法");

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