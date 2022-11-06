package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.CartGoodsMapper;
import com.nfsn.model.entity.CartGoods;
import com.nfsn.service.CartGoodsService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【cart_goods】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class CartGoodsServiceImpl extends ServiceImpl<CartGoodsMapper, CartGoods>
implements CartGoodsService{

}
