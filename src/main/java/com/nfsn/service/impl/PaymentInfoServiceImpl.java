package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.PaymentInfoMapper;
import com.nfsn.model.entity.PaymentInfo;
import com.nfsn.service.PaymentInfoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【payment_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper, PaymentInfo>
implements PaymentInfoService{

}
