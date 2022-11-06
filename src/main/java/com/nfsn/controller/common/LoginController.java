package com.nfsn.controller.common;

import com.nfsn.model.dto.LoginRequest;
import com.nfsn.model.vo.LoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    //获取验证码
    @ApiOperation("获取验证码")
    @GetMapping("/getVerifyCode/{phone}")
    public LoginVO getVerifyCode(@PathVariable("phone") String phone) {
        return null;
    }

    //用户手机号登录
    @ApiOperation("用户手机号登录")
    @PostMapping("/user/login")
    public LoginVO userLoginByPhone(@RequestBody LoginRequest loginRequest) {
        return null;
    }

    //用户微信授权登录
    @ApiOperation("用户微信授权登录")
    @PostMapping("/user/login/wx")
    public LoginVO userLoginByWx(@RequestBody LoginRequest loginRequest) {
        return null;
    }

    //用户QQ授权登录
    @ApiOperation("用户QQ授权登录")
    @PostMapping("/user/login/qq")
    public LoginVO userLoginByQQ(@RequestBody LoginRequest loginRequest) {
        return null;
    }

    //商家账号密码登录
    @ApiOperation("商家账号密码登录")
    @PostMapping("/merchant/login")
    public LoginVO merchantLogin(@RequestBody LoginRequest loginRequest) {
        return null;
    }

    //平台管理员账号密码登录
    @ApiOperation("平台管理员账号密码登录")
    @PostMapping("/admin/login")
    public LoginVO platformAdministratorLogin(@RequestBody LoginRequest loginRequest) {
        return null;
    }
}
