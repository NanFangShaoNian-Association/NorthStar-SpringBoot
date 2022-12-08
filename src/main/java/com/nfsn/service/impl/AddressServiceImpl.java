package com.nfsn.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.AddressMapper;
import com.nfsn.model.entity.Address;
import com.nfsn.model.entity.City;
import com.nfsn.model.entity.Province;
import com.nfsn.model.entity.Region;
import com.nfsn.model.vo.UserAddressVO;
import com.nfsn.service.AddressService;
import com.nfsn.service.CityService;
import com.nfsn.service.ProvinceService;
import com.nfsn.service.RegionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【address】的数据库操作Service实现
* @createDate 2022-10-30 21:44:05
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
implements AddressService{
    @Resource
    private ProvinceService provinceService;

    @Resource
    private CityService cityService;

    @Resource
    private RegionService regionService;

    /**
     * 根据用户id查询地址列表
     *
     * @return 用户id
     */
    @Override
    public List<UserAddressVO> listByUserId(Integer id) {

        //获取地址列表信息
        List<Address> addressList = this.list(new LambdaQueryWrapper<Address>()
                .eq(Address::getUserId,id)
                .eq(Address::getDeleted,0));//未删除

        List<UserAddressVO> userAddressVOList = BeanUtil.copyToList(addressList, UserAddressVO.class);

        //查找省市区信息
        List<Province> provinces = provinceService.list();
        List<City> cities = cityService.list();
        List<Region> regions = regionService.list();
        StringBuilder place = null;
        //填充省市区信息
        for (int i = 0; i < userAddressVOList.size(); i++) {
            place = new StringBuilder();
            //查找省市区信息
            for (int j = 0; j < provinces.size(); j++) {
                if (provinces.get(j).getId().equals(userAddressVOList.get(i).getId())) {
                    userAddressVOList.get(i).setProvinceId(provinces.get(j).getId());
                    place.append(provinces.get(j).getProvinceName() + "-");
                    break;
                }
            }
            for (int j = 0; j < cities.size(); j++) {
                if (cities.get(i).getId().equals(userAddressVOList.get(i).getId())) {
                    userAddressVOList.get(i).setCityId(cities.get(j).getId());
                    place.append(cities.get(j).getCityName() + "-");
                    break;
                }
            }
            for (int j = 0; j < regions.size(); j++) {
                if (regions.get(j).getId().equals(userAddressVOList.get(i).getId())) {
                    userAddressVOList.get(i).setRegionId(regions.get(j).getId());
                    place.append(regions.get(j).getRegion());
                    break;
                }
            }
            userAddressVOList.get(i).setPlace(place.toString());
        }

        return userAddressVOList;
    }

    /**
     * 根据用户id确认该地址是否为自己的，再根据地址id查询该地址
     *
     * @param id 用户id
     * @param addressId 地址id
     * @return
     */
    @Override
    public UserAddressVO getAddressById(Integer id, Integer addressId) {
        Address address = this.getOne(new LambdaQueryWrapper<Address>()
                .eq(Address::getUserId, id)
                .eq(Address::getId, addressId));

        UserAddressVO addressVO = BeanUtil.copyProperties(address, UserAddressVO.class);

        //查找省市区信息
        List<Province> provinces = provinceService.list();
        List<City> cities = cityService.list();
        List<Region> regions = regionService.list();
        StringBuilder place = new StringBuilder();
        //查找省市区信息
        for (int i = 0; i < provinces.size(); i++) {
            if (provinces.get(i).getId().equals(addressVO.getId())) {
                addressVO.setProvinceId(provinces.get(i).getId());
                place.append(provinces.get(i).getProvinceName() + "-");
                break;
            }
        }
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getId().equals(addressVO.getId())) {
                addressVO.setCityId(cities.get(i).getId());
                place.append(cities.get(i).getCityName() + "-");
                break;
            }
        }
        for (int i = 0; i < regions.size(); i++) {
            if (regions.get(i).getId().equals(addressVO.getId())) {
                addressVO.setRegionId(regions.get(i).getId());
                place.append(regions.get(i).getRegion());
                break;
            }
        }
        addressVO.setPlace(place.toString());
        return addressVO;
    }

}
