package com.nfsn.advice;

import com.nfsn.common.Result;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    //用户登录异常拦截
    @ExceptionHandler(UserLoginException.class)
    public Result userLoginExceptionHandler(HttpServletRequest req, UserLoginException e) {
        log.error("出现UserLoginException异常：",e);
        return Result.failure(e.getResultCode(), null);
    }

    //用户异常拦截
    @ExceptionHandler(UserException.class)
    public Result userLoginExceptionHandler(HttpServletRequest req, UserException e) {
        log.error("出现UserException异常：",e);
        return Result.failure(e.getResultCode(), null);
    }

    //用户自己的文章异常拦截
    @ExceptionHandler(UserArticleException.class)
    public Result userArticleExceptionHandler(HttpServletRequest req, UserArticleException e) {
        log.error("出现UserArticleException异常：",e);
        return Result.failure(e.getResultCode(), null);
    }

    //宠物操作异常拦截
    @ExceptionHandler(UserPetException.class)
    public Result userPetExceptionHandler(HttpServletRequest req, UserPetException e) {
        log.error("出现UserPetException异常：",e);
        return Result.failure(e.getResultCode(), null);
    }

    //用户视频异常拦截
    @ExceptionHandler(UserVideoException.class)
    public Result userVideoExceptionHandler(HttpServletRequest req, UserVideoException e) {
        log.error("出现UserVideoException异常：",e);
        return Result.failure(e.getResultCode(), null);
    }

    //参数转换异常拦截，-1为系统异常
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Result paramExceptionHandler(HttpServletRequest req, HttpMessageNotReadableException e) {
        log.error("出现HttpMessageNotReadableException异常：",e);
        return new Result(-1,e.getCause().toString(), null);
    }

    //todo:支付异常拦截

    //空指针异常
    @ExceptionHandler(NullPointerException.class)
    public Result internalExceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("出现NullPointerException异常：",e);
        return Result.failure(ResultCode.PARAM_IS_BLANK, e.getMessage());
    }

    //其他异常拦截
    @ExceptionHandler(Exception.class)
    public Result internalExceptionHandler(HttpServletRequest req, Exception e) {
        log.error("出现Exception异常：",e);
        return new Result(ResultCode.INTERNAL_ERROR.getCode(),e.getCause().toString(), null);
    }
}
