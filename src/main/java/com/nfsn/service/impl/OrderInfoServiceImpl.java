package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.constants.OrderStatus;
import com.nfsn.mapper.OrderInfoMapper;
import com.nfsn.model.dto.CreateOrderRequest;
import com.nfsn.model.dto.UserOrderRequest;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.model.entity.User;
import com.nfsn.model.vo.UserOrderListVO;
import com.nfsn.model.vo.UserOrderVO;
import com.nfsn.service.GoodsService;
import com.nfsn.service.OrderInfoService;
import com.nfsn.utils.AccountHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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

    @Resource
    private GoodsService goodsService;

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

    /**
     * 创建订单并返回订单信息
     *
     * @param createOrderRequest 创建支付订单传输实体
     * @return 订单信息
     */
    @Override
    public OrderInfo createOrder(CreateOrderRequest createOrderRequest) {
        //查询商品
        Goods good = goodsService.getOne(new LambdaQueryWrapper<Goods>().eq(Goods::getId, createOrderRequest.getGoodId()));
        //商品不存在
        if (good == null){
            //todo：抛出商品编号不存在异常
        }
        //库存不足
        if (good.getGoodsStocks() >= createOrderRequest.getCount()){
            //todo：抛出商品库存不足异常
        }
        //封装订单信息
        OrderInfo orderInfo = BeanUtil.copyProperties(createOrderRequest, OrderInfo.class);
        orderInfo.setId((int) IdUtil.getSnowflake().nextId());//雪花算法生成id
        orderInfo.setUserId(AccountHolder.getUser().getId());
        orderInfo.setMerchantId(good.getMerchantId());
        orderInfo.setOrderNo((int) IdUtil.getSnowflake().nextId());//雪花算法生成订单编号
        orderInfo.setOrderStatus(OrderStatus.WAITING_PAID.getCode());//待支付
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        //创建订单信息
        this.save(orderInfo);
        return orderInfo;
    }

    @Override
    public List<UserOrderListVO> listOrder() {
        User user = AccountHolder.getUser();
        //根据用户id查询并根据订单状态排序
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<OrderInfo>()
                .eq(OrderInfo::getUserId, user.getId())
                .orderBy(true, true, OrderInfo::getOrderStatus);
        List<OrderInfo> orderInfoList = this.list(queryWrapper);
        List<UserOrderListVO> orderListVOList = BeanUtil.copyToList(orderInfoList, UserOrderListVO.class);

        //参数补全

        return orderListVOList;
    }

    @Override
    public UserOrderVO getOrder(Integer orderId) {
        User user = AccountHolder.getUser();
        //根据用户id和订单id查询订单
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<OrderInfo>()
                .eq(OrderInfo::getUserId, user.getId())
                .eq(OrderInfo::getOrderNo, orderId);
        OrderInfo orderInfo = this.getOne(queryWrapper);
        UserOrderVO userOrderVO = BeanUtil.copyProperties(orderInfo, UserOrderVO.class);

        //参数补全

        return userOrderVO;
    }

}
