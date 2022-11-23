package com.nfsn.controller.user;

import com.nfsn.mapper.CartMapper;
import com.nfsn.model.entity.Cart;
import com.nfsn.model.vo.CartItemVO;
import com.nfsn.model.vo.CartVO;
import com.nfsn.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    private CartService cartService;

    @GetMapping("/list/{userId}")
    @ApiOperation("获取购物车列表")
    public CartVO list(@PathVariable("userId") String userId){
        CartVO cartVO = new CartVO();
        List<CartItemVO> cartItemVOList = new ArrayList<>();

        // 根据用户id查购物车id
        int cartId = cartService.getCartIdByUserId(userId);

        return cartVO;
    }

//    //获取好友信息
//    @GetMapping("/getFriend/{userId}/{friendId}")
//    @ApiOperation("获取购物车信息")
//    public String getFriend(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId){
//        return "list";
//    }
}
