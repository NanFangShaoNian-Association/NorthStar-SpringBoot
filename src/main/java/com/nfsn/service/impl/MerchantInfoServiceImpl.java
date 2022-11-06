package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.MerchantInfoMapper;
import com.nfsn.model.entity.MerchantInfo;
import com.nfsn.service.MerchantInfoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【merchant_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class MerchantInfoServiceImpl extends ServiceImpl<MerchantInfoMapper, MerchantInfo>
implements MerchantInfoService{

}
