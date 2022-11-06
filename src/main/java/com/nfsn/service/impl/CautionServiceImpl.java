package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.CautionMapper;
import com.nfsn.model.entity.Caution;
import com.nfsn.service.CautionService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【caution】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class CautionServiceImpl extends ServiceImpl<CautionMapper, Caution>
implements CautionService{

}
