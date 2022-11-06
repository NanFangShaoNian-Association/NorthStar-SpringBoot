package com.nfsn.controller.user;

import com.nfsn.model.vo.UserGoodListVO;
import com.nfsn.model.vo.UserGoodVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/list")
    @ApiOperation("获取用户浏览商品列表")
    public List<UserGoodListVO> list(){
        return null;
    }

    @GetMapping("/getGood/{goodId}")
    @ApiOperation("获取用户浏览商品详情")
    public UserGoodVO getGood(@PathVariable("goodId") String goodId){
        return null;
    }

}
