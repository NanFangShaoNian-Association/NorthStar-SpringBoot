package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ProvinceMapper;
import com.nfsn.model.entity.Province;
import com.nfsn.service.ProvinceService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【province】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province>
implements ProvinceService{

}
