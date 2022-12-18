package com.nfsn.controller.merchant;

import cn.hutool.core.bean.BeanUtil;
import com.nfsn.model.dto.GoodsRequest;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.entity.MerchantType;
import com.nfsn.model.vo.GoodListVO;
import com.nfsn.model.vo.GoodTypeVO;
import com.nfsn.model.vo.GoodVO;
import com.nfsn.service.GoodsService;
import com.nfsn.service.MerchantImagesService;
import com.nfsn.service.MerchantInfoService;
import com.nfsn.service.MerchantTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MerchantController
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 09:29
 * @Description: 商家端商品操作类
 */
@RestController
@RequestMapping("/merchant/goods")
@Api("商家端商品操作类")
public class MerchantGoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private MerchantImagesService merchantImagesService;

    @Resource
    private MerchantInfoService merchantInfoService;
    @Resource
    private MerchantTypeService merchantTypeService;

    //获取商品列表
    @ApiOperation("获取商品列表")
    @GetMapping("/list/{merchantId}")
    public List<GoodListVO> list(@PathVariable("merchantId") Integer merchantId) {
        List<GoodListVO> goodListVOList = new ArrayList<>();

        List<Goods> goodsList = goodsService.getGoodsList();

        //将goodsList封装进userGoodsListVOS
        for (int i = 0; i < goodsList.size(); i++) {
            GoodListVO goodListVO = new GoodListVO();
            Goods goods = goodsList.get(i);

            BeanUtils.copyProperties(goods,goodListVO);
            goodListVO.setImage(merchantImagesService.getGoodsOneImageByGoodsId(goods.getMerchantId()));

            goodListVOList.add(goodListVO);
        }

        return goodListVOList;
    }

    //获取商品详情
    @ApiOperation("获取商品详情")
    @GetMapping("/getGood/{merchantId}/{goodId}")
    public GoodVO getGood(@PathVariable("goodId") Integer goodId, @PathVariable("merchantId") Integer merchantId) {
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


        // 2.转换
        BeanUtils.copyProperties(goods,goodVO);

        return goodVO;
    }

    //上架商品：商品名、商品图、规格等信息
    @ApiOperation("上架商品")
    @PostMapping("/putAwayGood")
    public void addGood(@RequestBody GoodsRequest goodsRequest) {
        Goods goods = BeanUtil.copyProperties(goodsRequest, Goods.class);
        goodsService.save(goods);
    }

    //修改商品信息
    @ApiOperation("修改商品信息")
    @PutMapping("/updateGood")
    public void updateGood(@RequestBody GoodsRequest goodsRequest) {
        Goods goods = BeanUtil.copyProperties(goodsRequest, Goods.class);
        goodsService.saveOrUpdate(goods);
    }

    //删除商品信息
    @ApiOperation("删除商品信息")
    @DeleteMapping("/deleteGood")
    public void deleteGood(@PathVariable("goodId") Integer goodId) {
        goodsService.removeById(goodId);
    }

    //获取商品类型
    @ApiOperation("获取商品类型")
    @GetMapping("/getGoodType")
    public List<GoodTypeVO> getGood() {
        List<MerchantType> merchantTypeList = merchantTypeService.list();
        return BeanUtil.copyToList(merchantTypeList, GoodTypeVO.class);
    }
}
