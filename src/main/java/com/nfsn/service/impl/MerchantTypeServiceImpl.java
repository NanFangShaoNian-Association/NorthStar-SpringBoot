package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.MerchantTypeMapper;
import com.nfsn.model.entity.MerchantType;
import com.nfsn.service.MerchantTypeService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【merchant_type】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class MerchantTypeServiceImpl extends ServiceImpl<MerchantTypeMapper, MerchantType>
implements MerchantTypeService{

}
