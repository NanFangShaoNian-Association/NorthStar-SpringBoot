package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.MerchantCommentMapper;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.entity.MerchantComment;
import com.nfsn.model.entity.MerchantInfo;
import com.nfsn.model.vo.GoodCommentVO;
import com.nfsn.model.vo.UserGoodListVO;
import com.nfsn.service.MerchantCommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【merchant_comment】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class MerchantCommentServiceImpl extends ServiceImpl<MerchantCommentMapper, MerchantComment>
implements MerchantCommentService{

    @Resource
    private MerchantCommentMapper merchantCommentMapper;

    @Override
    public List<GoodCommentVO> getGoodsCommentListByGoodsId(String goodId) {
        List<GoodCommentVO> goodsCommentVOList = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("goods_id",goodId);
        List<MerchantComment> merchantCommentList = merchantCommentMapper.selectByMap(map);

        for (int i = 0; i < merchantCommentList.size(); i++) {
            GoodCommentVO goodsCommentVO = new GoodCommentVO();

            MerchantComment goodsComment = merchantCommentList.get(i);

            BeanUtils.copyProperties(goodsComment,goodsCommentVO);

            goodsCommentVOList.add(goodsCommentVO);
        }

        return goodsCommentVOList;
    }
}
