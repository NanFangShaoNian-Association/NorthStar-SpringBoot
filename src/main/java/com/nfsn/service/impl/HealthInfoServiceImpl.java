package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.HealthInfoMapper;
import com.nfsn.model.entity.HealthInfo;
import com.nfsn.service.HealthInfoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【health_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class HealthInfoServiceImpl extends ServiceImpl<HealthInfoMapper, HealthInfo>
implements HealthInfoService{

}
