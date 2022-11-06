package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.CityMapper;
import com.nfsn.model.entity.City;
import com.nfsn.service.CityService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【city】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City>
implements CityService{

}
