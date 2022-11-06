package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.VideoCommentMapper;
import com.nfsn.model.entity.VideoComment;
import com.nfsn.service.VideoCommentService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【video_comment】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class VideoCommentServiceImpl extends ServiceImpl<VideoCommentMapper, VideoComment>
implements VideoCommentService{

}
