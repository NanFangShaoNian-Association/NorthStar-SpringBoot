package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.VideoMapper;
import com.nfsn.model.entity.Video;
import com.nfsn.service.VideoService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【video】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService {

}




