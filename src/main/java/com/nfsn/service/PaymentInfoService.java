package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.model.entity.PaymentInfo;


/**
* @author Tuanzi
* @description 针对表【payment_info】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface PaymentInfoService extends IService<PaymentInfo> {

    /**
     * 创建支付记录并返回支付记录信息
     *
     * @param orderInfo 支付记录
     * @param content 内容（json数据）
     * @return 支付记录信息
     */
    public PaymentInfo createPaymentInfo(OrderInfo orderInfo, String content);
}
