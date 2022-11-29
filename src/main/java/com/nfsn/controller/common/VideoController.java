package com.nfsn.controller.common;

import com.nfsn.model.entity.Video;
import com.nfsn.model.entity.VideoComment;
import com.nfsn.model.vo.VideoCommentVO;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.model.vo.VideoVO;
import com.nfsn.service.UserService;
import com.nfsn.service.VideoCommentService;
import com.nfsn.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.nfsn.constants.VideoConstans.VIDEO_INTRODUCTION_LONG;

/**
 * @ClassName: UserVideoController
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:11
 * @Description: 视频操作类
 */
@RestController
@RequestMapping("/videos")
@Api("视频操作类")
public class VideoController {

    @Resource
    private VideoService videoService;

    @Resource
    private UserService userService;

    @Resource
    private VideoCommentService videoCommentService;

    @GetMapping("/list")
    @ApiOperation("获取视频列表")
    public List<VideoListVO> list(){

        List<VideoListVO> videoListVOList = new ArrayList<>();

        List<Video> videoList = videoService.getVideoList();

        //将videoList封装进videoVOList
        for (int i = 0; i < videoList.size(); i++) {
            VideoListVO videoListVO = new VideoListVO();
            Video video = videoList.get(i);
            BeanUtils.copyProperties(video,videoListVO);
            videoListVO.setUserName(userService.getUserNameById(video.getUserId()));
            videoListVO.setArticleContent(video.getVideoContent().substring(0,VIDEO_INTRODUCTION_LONG));
            videoListVOList.add(videoListVO);
        }

        return videoListVOList;
    }

    @GetMapping("/getVideo/{videoId}")
    @ApiOperation("获取视频详情")
    public VideoVO getVideo(@PathVariable("videoId") String videoId){
        VideoVO videoVO = new VideoVO();
        Video video = videoService.getVideoById(videoId);
        BeanUtils.copyProperties(video,videoVO);
        // 根据用户id，从用户表中获取用户名，并封装入videoVO中
        videoVO.setUserName(userService.getUserNameById(video.getUserId()));

        List<VideoCommentVO> videoCommentVOList = new ArrayList<>();
        List<VideoComment> videoCommentList = videoCommentService.getVideoCommentByVideoId(videoId);

        // 根据视频id，从video_comment表中获取所有这篇视频的评论，并封装入videoVO中
        for (int i = 0; i < videoCommentList.size(); i++) {
            VideoCommentVO videoCommentVOS = new VideoCommentVO();
            VideoComment videoComment = videoCommentList.get(i);

            BeanUtils.copyProperties(videoComment,videoCommentVOS);
            //转换articleComment类中的用户id为articleCommentVOS中的评论者id
            videoCommentVOS.setReviewerId(videoComment.getUserId());

            videoCommentVOList.add(videoCommentVOS);
        }

        // 封装评论列表
        videoVO.setComments(videoCommentVOList);

        // 封装评论数
        videoVO.setCommentCount(videoCommentList.size());
        return videoVO;
    }
}
