package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.MerchantMapper;
import com.nfsn.model.entity.Merchant;
import com.nfsn.service.MerchantService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【merchant】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class MerchantServiceImpl extends ServiceImpl<MerchantMapper, Merchant>
implements MerchantService{

}
