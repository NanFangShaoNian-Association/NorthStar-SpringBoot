package com.nfsn.interceptor;

import com.nfsn.anno.NoNeedLogin;
import com.nfsn.common.ResultCode;
import com.nfsn.exception.UserLoginException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("LoginInterceptor已拦截");
        //是不是映射到方法上
        boolean isHandlerMethod = handler instanceof HandlerMethod;
        if(!isHandlerMethod){
//            System.out.println("不是方法上");
            return true;
        }
        //不需要登录的注解
        boolean isNoNeedLogin= ((HandlerMethod) handler).getMethodAnnotation(NoNeedLogin.class)!=null;
        if(isNoNeedLogin){
//            System.out.println("无需登录");
            return true;
        }

//        ((HandlerMethod) handler).getMethodAnnotation(BasicErrorController.class)!=null;
        //需要登录验证
        String token = request.getHeader("Authorization");

        if(null == token){
            throw new UserLoginException(ResultCode.USER_TOKEN_IS_BLANK);
//            System.out.println("无token");
        }else {
            //此处做token及其身份验证
            if (!"token".equals(token)) {
                throw new UserLoginException(ResultCode.USER_TOKEN_IS_INVALID);
            }
            System.out.println("成功");
//            Claims claims = null;
//            try{
//                claims = TokenUtil.parseJwt(token);
//            }catch (Exception e){
//                throw new UserLoginException(ResultCode.USER_TOKEN_IS_INVALID);
////                System.out.println("token有误");
//            }
//            //验证逻辑，暂时不校验
//            if (null != claims){
//                System.out.println("成功");
//                return true;
//            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}