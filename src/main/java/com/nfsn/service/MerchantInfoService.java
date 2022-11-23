package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.MerchantInfo;

/**
* @author Tuanzi
* @description 针对表【merchant_info】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface MerchantInfoService extends IService<MerchantInfo> {

    String getMerchantInfoDetailContentByGoodsId(int merchantInfoId);
}
