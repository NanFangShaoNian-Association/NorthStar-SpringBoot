package com.nfsn.controller.common;

import com.nfsn.anno.NoNeedLogin;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserLoginException;
import com.nfsn.model.dto.LoginRequest;
import com.nfsn.model.vo.LoginVO;
import com.nfsn.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: LoginController
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 08:48
 * @Description: 三端角色登录注册接口
 */
@Api("三端角色登录注册接口")
@RestController
@RequestMapping("/api")
public class LoginController {
    @Resource(name = "loginService")
    private LoginServiceImpl loginService;

    //获取验证码
    @ApiOperation("获取验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "phone", value = "用户手机号", dataType = "String", required = true)
    })
    @GetMapping("/getVerifyCode/{phone}")
    @NoNeedLogin//不需要登陆验证的方法加上该注解
    public void getVerifyCode(@PathVariable("phone") String phone) {
        //校验非空
        if (!StringUtils.hasLength(phone)) {
            throw new UserLoginException(ResultCode.PARAM_IS_BLANK);
        }

        //逻辑判断
        loginService.getVerifyCode(phone);
    }

    //用户手机号登录
    @ApiOperation("用户手机号登录(不需要密码登录)")
    @PostMapping("/user/login")
    @NoNeedLogin
    public LoginVO userLoginByPhone(@RequestBody LoginRequest loginRequest) {
        //校验必要参数非空
        if (!StringUtils.hasText(loginRequest.getPhone())&&
                !StringUtils.hasText(loginRequest.getVerifyCode())&&
                !(loginRequest.getRoleId() == 0)) {
            throw new UserLoginException(ResultCode.PARAM_IS_BLANK);
        }

        //逻辑判断
        LoginVO loginVO = loginService.userLoginByPhone(loginRequest);

        return loginVO;
    }

    //用户微信授权登录
    @ApiOperation("用户微信授权登录")
    @PostMapping("/user/login/wx")
    @NoNeedLogin
    public LoginVO userLoginByWx(@RequestBody LoginRequest loginRequest) {
        return null;
    }

    //用户QQ授权登录
    @ApiOperation("用户QQ授权登录")
    @PostMapping("/user/login/qq")
    @NoNeedLogin
    public LoginVO userLoginByQQ(@RequestBody LoginRequest loginRequest) {
        return null;
    }

    //商家账号密码登录
    @ApiOperation("商家账号密码登录")
    @PostMapping("/merchant/login")
    @NoNeedLogin
    public LoginVO merchantLogin(@RequestBody LoginRequest loginRequest) {
        return null;
    }

    //平台管理员账号密码登录
    @ApiOperation("平台管理员账号密码登录")
    @PostMapping("/admin/login")
    @NoNeedLogin
    public LoginVO platformAdministratorLogin(@RequestBody LoginRequest loginRequest) {
        return null;
    }
}
