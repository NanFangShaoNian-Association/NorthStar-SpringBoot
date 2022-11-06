package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.OrderInfoMapper;
import com.nfsn.model.entity.OrderInfo;
import com.nfsn.service.OrderInfoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【order_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
implements OrderInfoService{

}
