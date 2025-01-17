package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.RegionMapper;
import com.nfsn.model.entity.Region;
import com.nfsn.service.RegionService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【region】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region>
implements RegionService{

}
