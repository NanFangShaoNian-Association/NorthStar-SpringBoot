package com.nfsn.controller.merchant;

import com.nfsn.model.vo.UserOrderListVO;
import com.nfsn.service.OrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: MerchantOrderController
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 15:11
 * @Description: 商家端商品订单操作类
 */
@RestController
@RequestMapping("/merchant/order")
@Api("商家端商品订单操作类")
public class MerchantOrderController {

    @Resource
    private OrderInfoService orderInfoService;


    //todo:获取订单列表：商品名、商品规格、商品价格、客户用户名
    @ApiOperation("获取订单列表")
    @GetMapping("/list/{merchantId}")
    public List<UserOrderListVO> list(@PathVariable("merchantId") Integer merchantId) {
        
        return orderInfoService.listOrder();
    }

    //发货：填写快递单号、快递公司

    //退货

    //取消订单
}
