package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.MessageInfoMapper;
import com.nfsn.model.entity.MessageInfo;
import com.nfsn.service.MessageInfoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【message_info】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class MessageInfoServiceImpl extends ServiceImpl<MessageInfoMapper, MessageInfo>
implements MessageInfoService{

}
