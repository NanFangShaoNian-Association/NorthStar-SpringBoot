package com.nfsn.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.AddressMapper;
import com.nfsn.model.entity.Address;
import com.nfsn.model.vo.UserAddressVO;
import com.nfsn.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【address】的数据库操作Service实现
* @createDate 2022-10-30 21:44:05
*/
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address>
implements AddressService{

    /**
     * 根据用户id查询地址列表
     *
     * @return 用户id
     */
    @Override
    public List<UserAddressVO> listByUserId(Integer id) {

        List<Address> addressList = this.list(new LambdaQueryWrapper<Address>()
                .eq(Address::getUserId,id)
                .eq(Address::getDeleted,0));//未删除
        List<UserAddressVO> userAddressVOList = BeanUtil.copyToList(addressList, UserAddressVO.class);
        return null;
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
        return null;
    }
}
