package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.MerchantImagesMapper;
import com.nfsn.model.entity.MerchantImages;
import com.nfsn.service.MerchantImagesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【merchant_images】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class MerchantImagesServiceImpl extends ServiceImpl<MerchantImagesMapper, MerchantImages>
implements MerchantImagesService{

    @Resource
    private MerchantImagesMapper merchantImagesMapper;

    /**
     * 根据商品id查询一张商品图片
     * @param merchantId
     * @return
     */
    @Override
    public String getGoodsOneImageByGoodsId(Integer merchantId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("merchant_id",merchantId);
        List<MerchantImages> merchantImages = merchantImagesMapper.selectByMap(map);
        if (merchantImages.size() == 0) {
            return null;
        }
        return merchantImages.get(0).getImageUrl();
    }

    /**
     * 根据商品iid查询所有商品图片
     * @param goodId
     * @return
     */
    @Override
    public List<String> getGoodsImagesByGoodsId(int goodId) {

        List<String> goodsImageList = new ArrayList<>();

        // 获取对于商品id的所有图片的数据
        HashMap<String, Object> map = new HashMap<>();
        map.put("merchant_id",goodId);
        List<MerchantImages> merchantImages = merchantImagesMapper.selectByMap(map);

        // 将merchantImages中的所有图片的url保存到goodsImageList中
        for (int i = 0; i < merchantImages.size(); i++) {
            goodsImageList.add(merchantImages.get(i).getImageUrl());
        }

        return goodsImageList;
    }
}