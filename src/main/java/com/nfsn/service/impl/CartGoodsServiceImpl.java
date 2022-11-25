package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.CartGoodsMapper;
import com.nfsn.model.dto.AddCartRequest;
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
    public List<CartGoods> getCartGoodsByUserId(Integer userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id",userId);
        return cartGoodsMapper.selectByMap(map);
    }

    /**
     * 根据商品id查出CartGoods表中对应的购物车的商品是否为空
     * @param goodsId
     * @return
     */
//    @Override
    public boolean getCartGoodsByGoodsId(Integer goodsId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("goods_id",goodsId);
        if (cartGoodsMapper.selectByMap(map) == null) {
            return true;
        }
        return false;
    }

    /**
     * 将商品增添到购物车中
     * @param addCartRequest
     */
    @Override
    public void insertGoodsToCart(AddCartRequest addCartRequest) {
        CartGoods cartGoods = new CartGoods();

        //先查询在购物车中，这位用户是否已经增添了这件商品，即查userid和goodsid是否同时不为null
        //如果是，商品的数量+1，如果不是，写入新的商品

        cartGoods.setGoodsId(addCartRequest.getGoodsId());
        cartGoods.setUserId(addCartRequest.getUserId());
        cartGoodsMapper.insert(cartGoods);
    }


}
