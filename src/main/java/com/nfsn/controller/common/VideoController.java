package com.nfsn.controller.common;

import com.nfsn.model.dto.AddVideoRequest;
import com.nfsn.model.entity.Video;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.model.vo.VideoVO;
import com.nfsn.service.UserService;
import com.nfsn.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

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
        return null;
    }

    @PostMapping("/addVideo")
    @ApiOperation("发布视频")
    public void addVideo(@RequestBody AddVideoRequest addVideoRequest){
    }
}
