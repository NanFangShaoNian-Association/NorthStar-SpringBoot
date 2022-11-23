package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.OrderInfoMapper;
import com.nfsn.model.dto.UserOrderRequest;
import com.nfsn.model.entity.MerchantImages;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.service.OrderInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【order_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
implements OrderInfoService{

    @Resource
    private OrderInfoMapper orderInfoMapper;

    /**
     * 通过商品id查询该商品的付款人数
     * @param merchantId
     * @return
     */
    @Override
    public String getPaymentCountByGoodsId(Integer merchantId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("goods_id",merchantId);
        List<OrderInfo> orderInfos = orderInfoMapper.selectByMap(map);
        return String.valueOf(orderInfos.size());
    }

    @Override
    public void insertOrder(UserOrderRequest userOrderRequest) {
        OrderInfo orderInfo = new OrderInfo();

        // 为每一件商品创建一个订单
        for (int i = 0; i < userOrderRequest.getOrders().size(); i++) {
            // 用户ID
            orderInfo.setUserId(userOrderRequest.getUserId());
            // 商品ID
            orderInfo.setGoodsId(userOrderRequest.getOrders().get(i).getId());
            // 商家ID

            // 发货地址ID
            orderInfo.setShipAddressId(userOrderRequest.getAddressId());
            // 商户订单编号

            // 订单标题

            // 订单金额（分）
            orderInfo.setTotalFee(userOrderRequest.getOrders().get(i).getPrice());
            // 订单二维码链接

            // 订单备注
            orderInfo.setOrderRemark(userOrderRequest.getOrderMark());
            // 创建时间

            // 更新时间

            orderInfoMapper.insert(orderInfo);
        }


    }

}
