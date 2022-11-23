package com.nfsn.controller.user;

import com.nfsn.model.dto.UpdateAddressRequest;
import com.nfsn.model.vo.UserAddressVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserOrderController
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 17:08
 * @Description: 用户端地址操作类
 */
@RestController
@RequestMapping("/users/address")
@Api("用户端地址操作类")
public class UserAddressController {
//    @Resource(name = "userAddressService")
//    private UserAddressServiceImpl userAddressService;

    //获取地址列表
    @ApiOperation("获取地址列表")
    @GetMapping("/list/{userId}")
    public List<UserAddressVO> list(@PathVariable("userId") Integer userId) {
        return null;
//        return userAddressService.list();
    }

    //获取详细地址
    @ApiOperation("获取详细地址")
    @GetMapping("/getAddress/{userId}/{addressId}")
    public UserAddressVO getAddress(@PathVariable("userId") Integer userId, @PathVariable("addressId") String addressId) {
        return null;
    }

    //编辑地址信息、新增地址信息（编辑存在地址id，新增地址id为空）
    @ApiOperation("编辑地址信息、新增地址信息（编辑存在地址id，新增地址id为空）")
    @PostMapping("/updateAddress")
    public void updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest) {
    }

}
