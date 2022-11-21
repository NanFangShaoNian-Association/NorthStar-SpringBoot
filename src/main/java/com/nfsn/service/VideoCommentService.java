package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.VideoComment;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【video_comment】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface VideoCommentService extends IService<VideoComment> {

    List<VideoComment> getVideoCommentByVideoId(String videoId);
}
