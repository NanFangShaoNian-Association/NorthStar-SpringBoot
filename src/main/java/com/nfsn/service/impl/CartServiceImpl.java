package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.CartMapper;
import com.nfsn.model.entity.Cart;
import com.nfsn.service.CartService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【cart】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart>
implements CartService{

}
