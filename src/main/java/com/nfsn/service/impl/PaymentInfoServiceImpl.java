package com.nfsn.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.PaymentInfoMapper;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.model.entity.PaymentInfo;
import com.nfsn.service.OrderInfoService;
import com.nfsn.service.PaymentInfoService;
import com.nfsn.utils.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
* @author Tuanzi
* @description 针对表【payment_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo>
implements PaymentInfoService{
    @Resource
    private OrderInfoService orderInfoService;




    /**
     * 创建支付记录并返回支付记录信息
     *
     * @param orderInfo 支付记录
     * @param content 内容（json数据）
     * @return 支付记录信息
     */
    @Override
    public PaymentInfo createPaymentInfo(OrderInfo orderInfo, String content) {
        //封装支付信息
        PaymentInfo paymentInfo = new PaymentInfo();
        paymentInfo.setId((int) IdUtil.getSnowflake().nextId());
        paymentInfo.setId(Integer.valueOf(RandomUtils.getRandomOfNumber(5)));
        paymentInfo.setOrderInfoId(orderInfo.getId());
//        paymentInfo.setTransactionNo();
//        paymentInfo.setPaymentType("alipay");
//        paymentInfo.setTradeType();
//        paymentInfo.setTradeState();
        paymentInfo.setPayerTotal(orderInfo.getTotalFee());
        paymentInfo.setContent(content);
        paymentInfo.setCreateTime(new Date());
        paymentInfo.setUpdateTime(new Date());
        this.save(paymentInfo);
        return paymentInfo;
    }
}
