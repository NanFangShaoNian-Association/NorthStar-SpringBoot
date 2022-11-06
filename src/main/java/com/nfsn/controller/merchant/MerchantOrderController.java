package com.nfsn.controller.merchant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: MerchantOrderController
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 15:11
 * @Description: 商家端商品订单操作类
 */
@RestController
@RequestMapping("/merchant/order")
@Api("商家端商品订单操作类（暂无思路）")
public class MerchantOrderController {

    //获取订单列表
    @ApiOperation("获取订单列表")
    @GetMapping("/list/{merchantId}")
    public void list(@PathVariable("merchantId") Integer merchantId) {
    }

    //发货

    //退货

    //取消订单
}
