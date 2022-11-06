package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.LocationInfoMapper;
import com.nfsn.model.entity.LocationInfo;
import com.nfsn.service.LocationInfoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【location_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoMapper, LocationInfo>
implements LocationInfoService{

}
