package com.nfsn.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.nfsn.model.dto.*;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.model.entity.PaymentInfo;
import com.nfsn.service.IPayService;
import com.nfsn.service.OrderInfoService;
import com.nfsn.service.PaymentInfoService;
import com.nfsn.utils.AlipayUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("aliPayService")
public class AliPayServiceImpl implements IPayService {

    @Resource
    private AlipayUtil alipayUtil;

    @Resource
    private PaymentInfoService paymentInfoService;

    @Resource
    private OrderInfoService orderInfoService;

    /**
     * 支付宝支付接口
     *
     * @param orderInfo 订单信息
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String pay(OrderInfo orderInfo) throws AlipayApiException {
        //封装支付实体
        AlipayBean alipayBean = new AlipayBean(String.valueOf(orderInfo.getId()),//订单id
                orderInfo.getTitle(),//订单标题
                String.valueOf(orderInfo.getTotalFee()),//订单金额
                null, null, null);
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();

        // 封装业务参数
        alipayRequest.setBizContent(JSON.toJSONString(alipayBean));

        //发起支付
        String body = alipayUtil.tradeAppPay(alipayRequest);

        //创建支付订单
        PaymentInfo paymentInfo = paymentInfoService.createPaymentInfo(orderInfo, body);
        return body;
    }

    /**
     * 订单查询接口
     *
     * @param queryOrderRequest 订单查询传输实体
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String queryOrder(QueryOrderRequest queryOrderRequest) throws AlipayApiException {
//        Map<String, Object> map = MapUtil.of("out_trade_no", queryOrderRequest.getOrderId());
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//        request.setBizContent(JSON.toJSONString(map));
//        //根据订单号查询支付宝记录
////        String tradeQuery = alipayUtil.tradeQuery(request);
//        orderInfoService.
        return "";
    }

    /**
     * 申请退款接口
     *
     * @param refundOrderRequest 申请退款传输实体
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String refund(RefundOrderRequest refundOrderRequest) throws AlipayApiException {
        return null;
    }

    /**
     * 查询退款接口
     *
     * @param queryRefundRequest 查询退款传输实体
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String queryRefund(QueryRefundRequest queryRefundRequest) throws AlipayApiException {
        return null;
    }

    /**
     * 关闭订单接口
     *
     * @param orderCloseRequest 关闭订单传输实体
     * @return
     * @throws AlipayApiException
     */
    @Override
    public String orderClose(OrderCloseRequest orderCloseRequest) throws AlipayApiException {
        return null;
    }

    /**
     * 获取账单的下载地址
     *
     * @param queryBillRequest 查询账单下载地址传输实体
     * @return 账单的下载地址
     * @throws AlipayApiException
     */
    @Override
    public String getBillUrl(QueryBillRequest queryBillRequest) throws AlipayApiException {
        return null;
    }
}