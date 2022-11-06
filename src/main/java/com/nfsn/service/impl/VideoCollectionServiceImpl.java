package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.VideoCollectionMapper;
import com.nfsn.model.entity.VideoCollection;
import com.nfsn.service.VideoCollectionService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【video_collection】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class VideoCollectionServiceImpl extends ServiceImpl<VideoCollectionMapper, VideoCollection>
implements VideoCollectionService{

}
