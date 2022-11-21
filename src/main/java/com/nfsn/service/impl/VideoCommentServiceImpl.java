package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.VideoCommentMapper;
import com.nfsn.model.entity.VideoComment;
import com.nfsn.service.VideoCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【video_comment】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentMapper, VideoComment>
implements VideoCommentService{

    @Resource
    private VideoCommentMapper videoCommentMapper;

    @Override
    public List<VideoComment> getVideoCommentByVideoId(String videoId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("video_id",videoId);
        List<VideoComment> videoCommentList = videoCommentMapper.selectByMap(map);
        return videoCommentList;
    }
}