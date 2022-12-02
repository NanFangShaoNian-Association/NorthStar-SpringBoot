package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.dto.CreateOrderRequest;
import com.nfsn.model.dto.UserOrderRequest;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.model.vo.UserOrderListVO;
import com.nfsn.model.vo.UserOrderVO;

import java.util.List;


/**
* @author Tuanzi
* @description 针对表【order_info】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface OrderInfoService extends IService<OrderInfo> {

    String getPaymentCountByGoodsId(Integer merchantId);

    void insertOrder(UserOrderRequest userOrderRequest);

    /**
     * 创建订单并返回订单信息
     *
     * @param createOrderRequest 创建支付订单传输实体
     * @return 订单信息
     */
    OrderInfo createOrder(CreateOrderRequest createOrderRequest);

    List<UserOrderListVO> listOrder();

    UserOrderVO getOrder(Integer orderId);
}
