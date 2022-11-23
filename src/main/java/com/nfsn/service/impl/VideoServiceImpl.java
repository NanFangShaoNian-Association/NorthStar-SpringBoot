package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.VideoMapper;
import com.nfsn.model.entity.Video;
import com.nfsn.service.VideoService;
import com.nfsn.utils.CacheClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【video】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService {

    @Resource
    private VideoMapper videoMapper;

    /**
     * 获取视频
     * @return
     */
    @Override
    public List<Video> getVideoList() {
        return videoMapper.selectList(null);
    }

    @Override
    public Video getVideoById(String videoId) {
        return videoMapper.selectById(videoId);
    }
}




