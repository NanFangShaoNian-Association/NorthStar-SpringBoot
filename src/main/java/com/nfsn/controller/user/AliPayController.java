package com.nfsn.controller.user;


import com.alipay.api.AlipayApiException;
import com.nfsn.anno.RawResource;
import com.nfsn.model.dto.QueryOrderRequest;
import com.nfsn.service.IPayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Api("支付宝支付接口")
public class AliPayController {
    @Resource
    private IPayService service;

//    @PostMapping(value = "/order/alipay")
//    @ApiOperation("手机网站支付")
//    @RawResource //按照原响应数据返回
//    @ApiImplicitParams({
//            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
//    })
//    public String alipay(@RequestBody CreateOrderRequest createOrderRequest) {
//        String body = null;
//        try {
//            body = service.pay(createOrderRequest);
//        } catch (AlipayApiException e) {
//            e.printStackTrace();
//        }
//        return body;
//    }

    @PostMapping(value = "/order/queryOrder")
    @ApiOperation("订单查询")
//    @NoNeedLogin //无需登录
    @RawResource //按照原响应数据返回
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public String queryOrder(@RequestBody QueryOrderRequest queryOrderRequest) throws AlipayApiException{
        return service.queryOrder(queryOrderRequest);
    }

}
