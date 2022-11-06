package com.nfsn.controller.user;

import com.nfsn.model.vo.DiscountCouponVO;
import com.nfsn.model.vo.UserDiscountCouponListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: UserDiscountCouponController
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:00
 * @Description: 用户优惠券操作类
 */
@RestController
@RequestMapping("/users/discountCoupon")
@Api("用户优惠券操作类")
public class UserDiscountCouponController {
    @GetMapping("/list/{userId}")
    @ApiOperation("获取用户所拥有优惠券列表")
    public List<UserDiscountCouponListVO> list(@PathVariable("userId") String userId){
        return null;
    }

    @GetMapping("/getDiscountCoupon/{discountCouponId}")
    @ApiOperation("获取用户所拥有优惠券详情")
    public DiscountCouponVO getDiscountCoupon(@PathVariable("discountCouponId") String discountCouponId){
        return null;
    }

}
