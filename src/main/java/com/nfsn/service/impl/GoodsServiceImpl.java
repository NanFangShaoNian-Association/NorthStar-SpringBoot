package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.GoodsMapper;
import com.nfsn.model.entity.Goods;
import com.nfsn.service.GoodsService;
import com.nfsn.utils.CacheClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.nfsn.common.RedisConstants.CACHE_GOODS_KEY;
import static com.nfsn.common.RedisConstants.CACHE_GOODS_TTL;

/**
* @author Tuanzi
* @description 针对表【goods】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods>
implements GoodsService{

    @Resource
    private CacheClient cacheClient;

    /**
     * 根据id查询货物信息
     * @param goodId
     * @return
     */
    @Override
    public Goods getGoodsById(String goodId) {
        Goods goods = cacheClient.queryWithPassThrough(CACHE_GOODS_KEY, goodId, Goods.class, this::getById, CACHE_GOODS_TTL, TimeUnit.MINUTES);
        return goods;
    }
}
