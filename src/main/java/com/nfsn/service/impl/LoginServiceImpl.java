package com.nfsn.service.impl;

import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserLoginException;
import com.nfsn.model.dto.LoginRequest;
import com.nfsn.model.vo.LoginVO;
import com.nfsn.utils.CacheClient;
import com.nfsn.utils.PhoneRegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.nfsn.constants.RedisConstants.LOGIN_CODE_KEY;
import static com.nfsn.constants.RedisConstants.LOGIN_CODE_TTL;

/**
 * @ClassName: LoginServiceImpl
 * @Author: 团子tz
 * @CreateTime: 2022/11/16 21:13
 * @Description: 想想此类的作用，写在这里吧。
 */
@Service("loginService")
@Slf4j
public class LoginServiceImpl {

    @Resource
    private CacheClient cacheClient;

    /**
     * 根据手机号获取验证码
     * @param phone 手机号
     */
    public void getVerifyCode(String phone) {
        //校验手机号的合理性
        if (!PhoneRegexUtils.isPhoneLegal(phone)) {
            //手机号不是中国【包括香港】的
            throw new UserLoginException(ResultCode.PARAM_IS_INVALID);
        }

        //生成随机验证码
//        String verifyCode = RandomUtils.getRandom(RandomUtils.ALL_LETTER_AND_NUMBER, 6);
        //固定验证码
        String verifyCode = "A1b2c3";
        //存储5分钟
        cacheClient.setWithLogicalExpire(LOGIN_CODE_KEY+phone,verifyCode,LOGIN_CODE_TTL, TimeUnit.MINUTES);
        log.info("目标手机号：{}，验证码：{}存储成功",phone,verifyCode);
        //todo:发送逻辑
        log.info("目标手机号：{}，验证码：{}发送成功",phone,verifyCode);
    }

    /**
     * 用户手机号登录(不需要密码登录)
     * @param loginRequest
     * @return
     */
    public LoginVO userLoginByPhone(LoginRequest loginRequest) {
        //校验验证码
        String verifyCode = cacheClient.queryWithPassThrough(LOGIN_CODE_KEY, loginRequest.getPhone(), String.class,
                s -> null, LOGIN_CODE_TTL, TimeUnit.MINUTES);


        return null;
    }

}
