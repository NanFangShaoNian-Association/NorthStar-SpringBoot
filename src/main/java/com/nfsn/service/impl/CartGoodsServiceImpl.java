package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.CartGoodsMapper;
import com.nfsn.model.entity.CartGoods;
import com.nfsn.service.CartGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【cart_goods】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class CartGoodsServiceImpl extends ServiceImpl<CartGoodsMapper, CartGoods>
implements CartGoodsService{

    @Resource
    private  CartGoodsMapper cartGoodsMapper;

    /**
     * 根据用户id查出CartGoods表中对应的购物车的所有商品
     * @param userId
     * @return
     */
    @Override
    public List<CartGoods> getCartGoodsByUserId(String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id",userId);
        return cartGoodsMapper.selectByMap(map);
    }
}
