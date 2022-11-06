package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.VideoTagMapper;
import com.nfsn.model.entity.VideoTag;
import com.nfsn.service.VideoTagService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【video_tag】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class VideoTagServiceImpl extends ServiceImpl<VideoTagMapper, VideoTag>
implements VideoTagService{

}
