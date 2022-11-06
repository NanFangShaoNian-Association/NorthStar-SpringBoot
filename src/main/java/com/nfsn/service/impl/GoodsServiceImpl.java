package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.GoodsMapper;
import com.nfsn.model.entity.Goods;
import com.nfsn.service.GoodsService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
implements GoodsService{

}
