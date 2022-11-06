package com.nfsn.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.AddressMapper;
import com.nfsn.model.entity.Address;
import com.nfsn.service.AddressService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【address】的数据库操作Service实现
* @createDate 2022-10-30 21:44:05
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
implements AddressService{

}
