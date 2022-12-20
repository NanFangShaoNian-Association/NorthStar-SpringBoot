package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.nfsn.model.dto.UpdateAddressRequest;
import com.nfsn.model.entity.*;
import com.nfsn.model.vo.CityVO;
import com.nfsn.model.vo.ProvinceVO;
import com.nfsn.model.vo.RegionVO;
import com.nfsn.model.vo.UserAddressVO;
import com.nfsn.service.AddressService;
import com.nfsn.service.CityService;
import com.nfsn.service.ProvinceService;
import com.nfsn.service.RegionService;
import com.nfsn.utils.AccountHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: UserAddressServiceImpl
 * @Author: 团子tz
 * @CreateTime: 2022/11/23 12:57
 * @Description: 想想此类的作用，写在这里吧。
 */
@Service("userAddressService")
@Slf4j
public class UserAddressServiceImpl {

    @Resource
    private AddressService addressService;

    @Resource
    private ProvinceService provinceService;

    @Resource
    private CityService cityService;

    @Resource
    private RegionService regionService;

    /**
     * 获取地址列表
     *
     * @return 地址列表
     */
    public List<UserAddressVO> list() {
        User user = AccountHolder.getUser();
        //根据用户id查询地址列表
        return addressService.listByUserId(user.getId());
    }

    /**
     * 获取详细地址
     *
     * @param addressId 地址id
     * @return 详细地址
     */
    public UserAddressVO getAddress(Integer addressId) {
        User user = AccountHolder.getUser();
        //根据用户id确认该地址是否为自己的，再根据地址id查询该地址
        return addressService.getAddressById(user.getId(),addressId);
    }

    /**
     * 编辑地址信息、新增地址信息（编辑存在地址id，新增地址id为空）
     *
     * @param updateAddressRequest 更新地址信息传输实体
     */
    public void updateAddress(UpdateAddressRequest updateAddressRequest) {
        Address address = BeanUtil.copyProperties(updateAddressRequest, Address.class);
        address.setDeleted(0);
        address.setUpdateTime(new Date());
        address.setCreateTime(new Date());

        addressService.saveOrUpdate(address);
    }

    /**
     * 删除地址信息
     *
     * @param addressId 地址id
     */
    public void deleteAddress(Integer addressId) {
        addressService.update(new LambdaUpdateWrapper<Address>()
                .eq(Address::getId,addressId)
                .set(Address::getDeleted,1));//设置已删除
    }

    /**
     * 获取省信息
     *
     * @return
     */
    public List<ProvinceVO> listProvince() {
        List<Province> provinceList = provinceService.list();
        List<ProvinceVO> provinceVOS = BeanUtil.copyToList(provinceList, ProvinceVO.class);
        return provinceVOS;
    }

    /**
     * 获取市信息
     *
     * @param provinceId
     * @return
     */
    public List<CityVO> listCity(Integer provinceId) {
        List<City> cityList = cityService.list(new LambdaQueryWrapper<City>().eq(City::getProvinceId, provinceId));;
        List<CityVO> cityVOS = BeanUtil.copyToList(cityList, CityVO.class);
        return cityVOS;
    }

    /**
     * 获取区信息
     *
     * @param cityId
     * @return
     */
    public List<RegionVO> listRegion(Integer cityId) {
        List<Region> regionList = regionService.list(new LambdaQueryWrapper<Region>().eq(Region::getCityId, cityId));
        List<RegionVO> regionVOS = BeanUtil.copyToList(regionList, RegionVO.class);
        return regionVOS;
    }
}
