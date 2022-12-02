package com.nfsn.service;

import com.alipay.api.AlipayApiException;
import com.nfsn.model.dto.*;
import com.nfsn.model.entity.OrderInfo;

public interface IPayService {
    /**
     * 支付接口
     *
     * @param orderInfo 订单信息
     * @return
     * @throws AlipayApiException
     */
    String pay(OrderInfo orderInfo) throws AlipayApiException;

    /**
     * 订单查询接口
     *
     * @param queryOrderRequest 订单查询传输实体
     * @return
     * @throws AlipayApiException
     */
    public String queryOrder(QueryOrderRequest queryOrderRequest) throws AlipayApiException;

    /**
     * 申请退款接口
     *
     * @param refundOrderRequest 申请退款传输实体
     * @return
     * @throws AlipayApiException
     */
    public String refund(RefundOrderRequest refundOrderRequest) throws AlipayApiException;

    /**
     * 查询退款接口
     *
     * @param queryRefundRequest 查询退款传输实体
     * @return
     * @throws AlipayApiException
     */
    public String queryRefund(QueryRefundRequest queryRefundRequest) throws AlipayApiException;

    /**
     * 关闭订单接口
     *
     * @param orderCloseRequest 关闭订单传输实体
     * @return
     * @throws AlipayApiException
     */
    public String orderClose(OrderCloseRequest orderCloseRequest) throws AlipayApiException;

    /**
     * 获取账单的下载地址
     *
     * @param queryBillRequest 查询账单下载地址传输实体
     * @return 账单的下载地址
     * @throws AlipayApiException
     */
    public String getBillUrl(QueryBillRequest queryBillRequest) throws AlipayApiException;

}
