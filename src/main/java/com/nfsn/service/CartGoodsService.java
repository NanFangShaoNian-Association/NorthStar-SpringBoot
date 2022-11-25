package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.dto.AddCartRequest;
import com.nfsn.model.entity.CartGoods;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【cart_goods】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface CartGoodsService extends IService<CartGoods> {

    List<CartGoods> getCartGoodsByUserId(Integer userId);

    void insertGoodsToCart(AddCartRequest addCartRequest);
}
