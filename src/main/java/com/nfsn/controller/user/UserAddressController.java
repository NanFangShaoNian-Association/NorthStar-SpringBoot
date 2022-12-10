package com.nfsn.controller.user;

import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserVideoException;
import com.nfsn.model.dto.UpdateAddressRequest;
import com.nfsn.model.vo.CityVO;
import com.nfsn.model.vo.ProvinceVO;
import com.nfsn.model.vo.RegionVO;
import com.nfsn.model.vo.UserAddressVO;
import com.nfsn.service.impl.UserAddressServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@Slf4j
public class UserAddressController {
    @Resource(name = "userAddressService")
    private UserAddressServiceImpl userAddressService;

    //获取地址列表
    @ApiOperation("获取地址列表")
    @GetMapping("/list")
    public List<UserAddressVO> list() {
        return userAddressService.list();
    }

    //获取省信息
    @ApiOperation("获取省信息")
    @GetMapping("/getProvince")
    public List<ProvinceVO> listProvince() {
        return userAddressService.listProvince();
    }

    //获取市信息
    @ApiOperation("获取市信息")
    @GetMapping("/getCity/{provinceId}")
    public List<CityVO> listCity(@PathVariable("provinceId") String provinceId) {
        Integer value = 0;
        try {
            value = Integer.valueOf(provinceId);
        } catch (NumberFormatException e) {
            log.error("UserAddressController getCity 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        return userAddressService.listCity(value);
    }

    //获取区信息
    @ApiOperation("获取区信息")
    @GetMapping("/getRegion/{cityId}")
    public List<RegionVO> listRegion(@PathVariable("cityId") String cityId) {
        Integer value = 0;
        try {
            value = Integer.valueOf(cityId);
        } catch (NumberFormatException e) {
            log.error("UserAddressController regionId 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        return userAddressService.listRegion(value);
    }

    //获取详细地址
    @ApiOperation("获取详细地址")
    @GetMapping("/getAddress/{addressId}")
    public UserAddressVO getAddress(@PathVariable("addressId") String addressId) {
        Integer value = 0;
        try {
            value = Integer.valueOf(addressId);
        } catch (NumberFormatException e) {
            log.error("UserAddressController getAddress 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        return userAddressService.getAddress(value);
    }

    //编辑地址信息、新增地址信息（编辑存在地址id，新增地址id为空）
    @ApiOperation("编辑地址信息、新增地址信息（编辑存在地址id，新增地址id为空）")
    @PostMapping("/updateAddress")
    public void updateAddress(@RequestBody UpdateAddressRequest updateAddressRequest) {
        userAddressService.updateAddress(updateAddressRequest);
    }

    //删除地址信息
    @DeleteMapping("/deleteAddress/{addressId}")
    @ApiOperation("删除地址")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void deleteAddress(@PathVariable("addressId") String addressId) {
        Integer value = 0;
        try {
            value = Integer.valueOf(addressId);
        } catch (NumberFormatException e) {
            log.error("UserAddressController getAddress 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        userAddressService.deleteAddress(value);
    }

}
