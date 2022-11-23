package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.MerchantComment;
import com.nfsn.model.vo.GoodCommentVO;

import java.util.List;


/**
* @author Tuanzi
* @description 针对表【merchant_comment】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface MerchantCommentService extends IService<MerchantComment> {

    List<GoodCommentVO> getGoodsCommentListByGoodsId(String goodId);
}
