package com.nfsn.advice;

import com.nfsn.common.Result;
import com.nfsn.exception.UserLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    //用户登录异常拦截
    @ExceptionHandler(UserLoginException.class)
    public Result userLoginExceptionHandler(HttpServletRequest req, UserLoginException e) {
        return new Result(e.getResultCode(),null);
    }
}