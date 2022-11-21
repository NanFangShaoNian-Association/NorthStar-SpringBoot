package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.vo.UserGoodListVO;

import java.util.List;


/**
* @author Tuanzi
* @description 针对表【goods】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface GoodsService extends IService<Goods> {

    Goods getGoodsById(String goodId);
}
