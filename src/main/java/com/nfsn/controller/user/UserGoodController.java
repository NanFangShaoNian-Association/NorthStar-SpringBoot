package com.nfsn.controller.user;

import cn.hutool.core.bean.BeanUtil;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.vo.GoodVO;
import com.nfsn.model.vo.UserGoodListVO;
import com.nfsn.model.vo.UserGoodVO;
import com.nfsn.service.GoodsService;
import com.nfsn.service.MerchantImagesService;
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
import java.util.List;

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

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private MerchantImagesService merchantImagesService;

    /**
     * 查询商品列表
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("获取用户浏览商品列表")
    public List<UserGoodListVO> list(){
//        UserGoodListVO userGoodListVO = new UserGoodListVO();
//        Goods goods = goodsService;
        return null;
    }

    @GetMapping("/getGood/{goodId}")
    @ApiOperation("获取用户浏览商品详情")
    public UserGoodVO getGood(@PathVariable("goodId") String goodId){
        // TODO 未完成

        UserGoodVO userGoodVO = new UserGoodVO();
        GoodVO goodVO = new GoodVO();

        // 1.查询
        // 1.1 根据商品id查询商品信息实体
        Goods goods = goodsService.getGoodsById(goodId);
        // 1.2 根据商品id查询商品图片列表
        // 1.3 根据商品id查询商品信息具体内容

        // 1.4 根据商品id查询评论实体


        // 2.转换
        BeanUtils.copyProperties(goods,goodVO);
        // 3.封装
        userGoodVO.setGood(goodVO);

        return userGoodVO;
    }

}
