package com.nfsn.controller.admin;

import com.nfsn.model.vo.GoodListVO;
import com.nfsn.model.vo.GoodVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: MerchantController
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 09:29
 * @Description: 平台端商品操作类
 */
@RestController
@RequestMapping("/admin/goods")
@Api("平台端商品操作类")
public class AdminGoodsController {

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

    //下架商品
    @ApiOperation("下架商品")
    @PostMapping("/soldOutGood/{goodId}")
    public void soldOutGood(@PathVariable("goodId") Integer goodId) {

    }
}
