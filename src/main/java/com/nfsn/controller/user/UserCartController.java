package com.nfsn.controller.user;

import com.nfsn.model.entity.CartGoods;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.vo.CartItemVO;
import com.nfsn.model.vo.CartVO;
import com.nfsn.service.CartGoodsService;
import com.nfsn.service.GoodsService;
import com.nfsn.service.MerchantImagesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserController
 * @Author: 团子tz
 * @CreateTime: 2022/10/30 20:40
 * @Description: 用户购物车操作类
 */
@RestController
@RequestMapping("/users/carts")
@Api("用户购物车操作类")
public class UserCartController {

    @Resource
    private CartGoodsService cartGoodsService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private MerchantImagesService merchantImagesService;

    @GetMapping("/list/{userId}")
    @ApiOperation("获取购物车列表")
    public List<CartItemVO> list(@PathVariable("userId") String userId){
//        CartVO cartVO = new CartVO();
        List<CartItemVO> cartItemVOList = new ArrayList<>();
        //使用用户id从CartGoods表中查出购物车的所有商品的列表
        List<CartGoods> cartGoodsList = cartGoodsService.getCartGoodsByUserId(userId);

        for (int i = 0; i < cartGoodsList.size(); i++) {
            Goods goods = goodsService.getGoodsById(cartGoodsList.get(i).getGoodsId());
            CartItemVO cartItemVO = new CartItemVO();
            //将CartGoods中的商品数量赋给每个cartItemVO
            cartItemVO.setNumber(cartGoodsList.get(i).getGoodsQuantity());
            cartItemVO.setImage(merchantImagesService.getGoodsOneImageByGoodsId(cartGoodsList.get(i).getGoodsId()));
//            cartGoodsList.get(i).setGoodsQuantity(cartGoodsList.get(i).get);
            BeanUtils.copyProperties(goods,cartItemVO);

            cartItemVOList.add(cartItemVO);
        }

        //根据查到的每个商品的id，去Goods表中查商品的标题、图片（一张）、规格、单价


        return cartItemVOList;
    }

//    //获取好友信息
//    @GetMapping("/getFriend/{userId}/{friendId}")
//    @ApiOperation("获取购物车信息")
//    public String getFriend(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId){
//        return "list";
//    }
}
