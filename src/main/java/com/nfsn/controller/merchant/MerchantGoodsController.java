package com.nfsn.controller.merchant;

import com.nfsn.model.dto.GoodsRequest;
import com.nfsn.model.vo.GoodListVO;
import com.nfsn.model.vo.GoodTypeVO;
import com.nfsn.model.vo.GoodVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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

    //获取商品列表
    @ApiOperation("获取商品列表")
    @GetMapping("/list/{merchantId}")
    public List<GoodListVO> list(@PathVariable("merchantId") Integer merchantId) {
        return null;
    }

    //获取商品详情
    @ApiOperation("获取商品详情")
    @GetMapping("/getGood/{merchantId}/{goodId}")
    public GoodVO getGood(@PathVariable("goodId") Integer goodId, @PathVariable("merchantId") Integer merchantId) {
        return null;
    }

    //上架商品
    @ApiOperation("上架商品")
    @PostMapping("/putAwayGood")
    public void addGood(@RequestBody GoodsRequest goodsRequest) {

    }

    //修改商品信息
    @ApiOperation("修改商品信息")
    @PutMapping("/updateGood")
    public void updateGood(@RequestBody GoodsRequest goodsRequest) {

    }

    //删除商品信息
    @ApiOperation("删除商品信息")
    @DeleteMapping("/deleteGood")
    public void deleteGood(@PathVariable("goodId") Integer goodId) {

    }

    //获取商品类型
    @ApiOperation("获取商品类型")
    @GetMapping("/getGoodType")
    public List<GoodTypeVO> getGood() {
        return null;
    }
}
