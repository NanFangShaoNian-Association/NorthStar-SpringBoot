package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.SessionMapper;
import com.nfsn.model.entity.Session;
import com.nfsn.service.SessionService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【session】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class SessionServiceImpl extends ServiceImpl<SessionMapper, Session>
implements SessionService{

}
