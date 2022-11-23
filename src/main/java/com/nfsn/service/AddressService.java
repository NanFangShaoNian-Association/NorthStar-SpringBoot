package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.Address;
import com.nfsn.model.vo.UserAddressVO;

import java.util.List;


/**
* @author Tuanzi
* @description 针对表【address】的数据库操作Service
* @createDate 2022-10-30 21:44:05
*/
public interface AddressService extends IService<Address> {

    /**
     * 根据用户id查询地址列表
     *
     * @return 地址列表
     */
    List<UserAddressVO> listByUserId(Integer id);

    /**
     * 根据用户id确认该地址是否为自己的，再根据地址id查询该地址
     *
     * @param id 用户id
     * @param addressId 地址id
     * @return
     */
    UserAddressVO getAddressById(Integer id, Integer addressId);

}
