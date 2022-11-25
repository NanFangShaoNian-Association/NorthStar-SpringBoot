package com.nfsn.controller.user;

import cn.hutool.core.bean.BeanUtil;
import com.nfsn.model.entity.*;
import com.nfsn.model.vo.GoodVO;
import com.nfsn.model.vo.UserGoodListVO;
import com.nfsn.model.vo.UserGoodVO;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.nfsn.constants.VideoConstans.VIDEO_INTRODUCTION_LONG;

/**
 * @ClassName: UserGoodController
 * @Author: 团子tz
 * @CreateTime: 2022/11/03 22:56
 * @Description: 用户商品操作类
 */
@RestController
@RequestMapping("/users/goods")
@Api("用户商品操作类")
public class UserGoodController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private MerchantImagesService merchantImagesService;

    @Resource
    private OrderInfoService orderInfoService;

    @Resource
    private MerchantInfoService merchantInfoService;

    @Resource
    private MerchantCommentService merchantCommentService;

    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("获取用户浏览商品列表")
    public List<UserGoodListVO> list(){
        List<UserGoodListVO> userGoodsListVOS = new ArrayList<>();

        List<Goods> goodsList = goodsService.getGoodsList();

        //将goodsList封装进userGoodsListVOS
        for (int i = 0; i < goodsList.size(); i++) {
            UserGoodListVO userGoodsListVO = new UserGoodListVO();
            Goods goods = goodsList.get(i);

            BeanUtils.copyProperties(goods,userGoodsListVO);
            userGoodsListVO.setImage(merchantImagesService.getGoodsOneImageByGoodsId(goods.getMerchantId()));
            userGoodsListVO.setPaymentCount(orderInfoService.getPaymentCountByGoodsId(goods.getMerchantId()));

            userGoodsListVOS.add(userGoodsListVO);
        }

        return userGoodsListVOS;
    }

    @GetMapping("/getGood/{goodId}")
    @ApiOperation("获取用户浏览商品详情")
    public UserGoodVO getGood(@PathVariable("goodId") int goodId){

        UserGoodVO userGoodVO = new UserGoodVO();

        GoodVO goodVO = new GoodVO();

        // 1.查询
        // 1.1 根据商品id查询商品信息实体
        Goods goods = goodsService.getGoodsById(goodId);

        if (goods == null) {
            return null;
        }

        // 1.2 根据商品id查询商品图片列表
        goodVO.setImages(merchantImagesService.getGoodsImagesByGoodsId(goodId));

        // 1.3 根据商品id查询商品信息具体内容
        goodVO.setMerchantInfoDetailContent(merchantInfoService.getMerchantInfoDetailContentByGoodsId(goods.getMerchantInfoId()));
        // 1.4 根据商品id查询评论实体
        userGoodVO.setGoodComment(merchantCommentService.getGoodsCommentListByGoodsId(goodId));

        // 2.转换
        BeanUtils.copyProperties(goods,goodVO);
        // 3.封装
        userGoodVO.setGood(goodVO);

        return userGoodVO;
    }

}
