package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.RefundInfoMapper;
import com.nfsn.model.entity.RefundInfo;
import com.nfsn.service.RefundInfoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【refund_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper, RefundInfo>
implements RefundInfoService{

}
