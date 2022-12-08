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
     * @param userId 用户id
     * @return id为“用户id”的用户的购物车列表
     */
    @Override
    public List<CartGoods> getCartGoodsByUserId(Integer userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id",userId);
        return cartGoodsMapper.selectByMap(map);
    }

    /**
     * 根据用户id和商品id查CartGoods表中对应的购物车的商品是否存在
     * @param goodsId 商品id
     * @return
     */
    public List<CartGoods> getCartGoodsByGoodsIdAndUserId(Integer goodsId,Integer userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_id",userId);
        map.put("goods_id",goodsId);
        return cartGoodsMapper.selectByMap(map);
    }

    /**
     * 将商品增添到购物车中
     * @param addCartRequest 增添到购物车实体
     */
    @Override
    public void insertGoodsToCart(AddCartRequest addCartRequest) {
        CartGoods cartGoods = new CartGoods();

        //先查询在购物车中，这位用户是否已经增添了这件商品，即查userid和goodsid是否同时不为null
        //如果不存在，写入新的商品
        List<CartGoods> cartGoodsList = getCartGoodsByGoodsIdAndUserId(addCartRequest.getGoodsId(), addCartRequest.getUserId());
        if (cartGoodsList.size() == 0){
            cartGoods.setGoodsId(addCartRequest.getGoodsId());
            cartGoods.setUserId(addCartRequest.getUserId());
            //这里先默认是1件，后面商品规格做出来后再改
            cartGoods.setGoodsQuantity(1);

            cartGoodsMapper.insert(cartGoods);
        }

        //如果存在，商品的数量+1，
        cartGoodsList.get(0).setGoodsQuantity(cartGoodsList.get(0).getGoodsQuantity()+1);

        cartGoodsMapper.insert(cartGoods);
    }
}
