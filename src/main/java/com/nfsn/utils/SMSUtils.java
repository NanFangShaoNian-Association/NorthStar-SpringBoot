package com.nfsn.utils;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.tea.TeaException;
import com.aliyun.teaopenapi.models.Config;
import com.aliyun.teautil.Common;
import com.aliyun.teautil.models.RuntimeOptions;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("aliyunCode")
public class SMSUtils {

    /**
     * 使用AK&SK初始化账号Client
     * @param accessKeyId
     * @param accessKeySecret
     * @return Client
     * @throws Exception
     */
    // 这里填写网站获取的accessKey
    static String accessKeyId = "LTAI5tFW5KbJ5rwYeAuehXc8";
    static String accessKeySecret = "lfNoMzEQyrshAYmxPrnfHzoOZ4WjV9";

    public static Client createClient(String accessKeyId, String accessKeySecret) throws Exception {
        Config config = new Config()
                // 您的 AccessKey ID
                .setAccessKeyId(accessKeyId)
                // 您的 AccessKey Secret
                .setAccessKeySecret(accessKeySecret);
        // 访问的域名
        config.endpoint = "dysmsapi.aliyuncs.com";
        return new Client(config);
    }

    // 生成4位随机数
    public static String smsCode(){
        // 用自带工具类，生成指定位数的随机码。
        String code = RandomUtils.getRandomOfNumber(4);
        String msg = "{\"code\":\""+code+"\"}";
        log.info("msg = "+msg);
        return code;
    }
    
    // 发送验证码
    public void sendCode(String phoneNumber, String code) throws Exception{
        //这里的accessKeyId需要我们填入刚刚添加的AccessKey的账号，后面那个参数为密码
        Client client = SMSUtils.createClient(accessKeyId, accessKeySecret);
        // 查看发送信息
        log.info("code = "+code);
        String msg = "{\"code\":\"" + code + "\"}";
        log.info("msg = "+msg);
        //发送
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                //短信的签名  测试阶段不能改[阿里云短信测试]
                .setSignName("北极星宠")
                //短信的模板码  测试阶段不能改
                .setTemplateCode("SMS_264186225")
                // 测试手机号  与绑定的测试手机号一致
                .setPhoneNumbers(phoneNumber)   // 实际开发中可自定义手机号
                //code后面的值为验证码，code的值只支持4-6位纯数字
                // 最终格式： 北极星宠登录专用验证码{"code":"1234"}
                .setTemplateParam("{\"code\":\"" + code + "\"}");
        RuntimeOptions runtime = new RuntimeOptions();
        try {
            // 打印 API 的返回值
            SendSmsResponse sendSmsResponse = client.sendSmsWithOptions(sendSmsRequest, runtime);
            // 响应结果转为json返回
            ObjectMapper objectMapper = new ObjectMapper();
            String respBody = objectMapper.writeValueAsString(sendSmsResponse.body);
            log.info("响应信息为:"+respBody);
        } catch (TeaException error) {
            // 如有需要，请打印 error
            Common.assertAsString(error.message);
        } catch (Exception _error) {
            TeaException error = new TeaException(_error.getMessage(), _error);
            // 如有需要，请打印 error
            Common.assertAsString(error.message);
        }
    }

}
