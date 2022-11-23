package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.CartMapper;
import com.nfsn.model.entity.Cart;
import com.nfsn.service.CartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
implements CartService{

    @Resource
    private CartMapper cartMapper;

    /**
     * 根据用户id查购物车id
     * @param userId
     * @return
     */
    @Override
    public int getCartIdByUserId(String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("age",3);
        List<Cart> cartList = cartMapper.selectByMap(map);
        return cartList.get(0).getId();
    }
}
