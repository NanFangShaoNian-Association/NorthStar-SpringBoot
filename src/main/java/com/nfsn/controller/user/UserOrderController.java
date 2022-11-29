package com.nfsn.controller.user;

import com.alipay.api.AlipayApiException;
import com.nfsn.anno.RawResource;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserArticleException;
import com.nfsn.model.dto.CreateOrderRequest;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.model.vo.UserOrderListVO;
import com.nfsn.model.vo.UserOrderVO;
import com.nfsn.service.IPayService;
import com.nfsn.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserOrderController
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 17:08
 * @Description: 用户端订单操作类
 */
@RestController
@RequestMapping("/users/orders")
@Api("用户端订单操作类")
@Slf4j
public class UserOrderController {

    @Resource
    private OrderInfoService orderInfoService;

    @Resource(name = "aliPayService")
    private IPayService payService;

    //创建订单
    @ApiOperation("创建订单")
    @PostMapping("/addOrder")
    @RawResource //返回原始数据
    public String addOrder(@RequestBody CreateOrderRequest createOrderRequest) throws AlipayApiException {
        //创建订单并返回订单信息
        OrderInfo orderInfo = orderInfoService.createOrder(createOrderRequest);
        //发起支付
        return payService.pay(orderInfo);
    }

    //获取订单列表
    @ApiOperation("获取订单列表")
    @GetMapping("/list")
    public List<UserOrderListVO> list() {
        return orderInfoService.listOrder();
    }

    //获取商品订单详情
    @ApiOperation("获取订单详情")
    @GetMapping("/getOrder/{orderId}")
    public UserOrderVO getOrder(@PathVariable("orderId") String orderId) {
        Integer value = 0;
        try {
            value = Integer.valueOf(orderId);
        } catch (NumberFormatException e) {
            log.error("UserOrderController getOrder NumberFormatException : ", e);
            throw new UserArticleException(ResultCode.PARAM_IS_INVALID);
        }
        return orderInfoService.getOrder(value);
    }


    //申请退款
    @ApiOperation("申请退款【暂不支持】")
    @GetMapping("/refund/{orderId}")
    public void refund(@PathVariable("orderId") String orderId) {
    }

}