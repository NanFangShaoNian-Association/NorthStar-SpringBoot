package com.nfsn.controller.user;

import com.nfsn.mapper.VideoMapper;
import com.nfsn.model.dto.AddVideoRequest;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.entity.Video;
import com.nfsn.model.vo.GoodVO;
import com.nfsn.model.vo.UserGoodVO;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.model.vo.VideoVO;
import com.nfsn.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserVideoController
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:11
 * @Description: 用户自己的视频操作类
 */
@RestController
@RequestMapping("/users/videos")
@Api("用户自己的视频操作类")
public class UserVideoController {

    @Resource
    private VideoService videoService;

    @GetMapping("/list")
    @ApiOperation("获取视频列表")
    public List<VideoListVO> list(){
        // 1.创建list集合，用于最终封装数据
        List<VideoListVO> videoListVOList = new ArrayList<>();

        // 2.查询
        // 2.1 查询视频列表
        List<Video> videoList = videoService.getVideoList();
        // 2.2

        // 2.遍历查询章节list集合进行封装，将videoList转为VideoListVO
        for (int i = 0; i < videoList.size(); i++) {
            VideoListVO videoListVO = new VideoListVO();
            Video video = videoList.get(i);
            // 根据用户id查询用户名


            BeanUtils.copyProperties(video,videoListVO);
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