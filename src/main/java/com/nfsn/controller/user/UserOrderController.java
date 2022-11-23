package com.nfsn.controller.user;

import com.nfsn.model.dto.UserOrderRequest;
import com.nfsn.model.vo.UserOrderListVO;
import com.nfsn.model.vo.UserOrderVO;
import com.nfsn.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
public class UserOrderController {

    @Resource
    private OrderInfoService orderInfoService;

    //获取订单列表
    @ApiOperation("获取订单列表")
    @GetMapping("/list/{userId}")
    public List<UserOrderListVO> list(@PathVariable("userId") Integer userId) {
        return null;
    }

    //获取商品详情
    @ApiOperation("获取订单详情")
    @GetMapping("/getOrder/{userId}/{orderId}")
    public UserOrderVO getOrder(@PathVariable("userId") Integer userId, @PathVariable("orderId") String orderId) {
        return null;
    }

    //创建订单
    @ApiOperation("创建订单")
    @PostMapping("/addOrder")
    public void addOrder(@RequestBody UserOrderRequest userOrderRequest) {
            orderInfoService.insertOrder(userOrderRequest);
    }
}