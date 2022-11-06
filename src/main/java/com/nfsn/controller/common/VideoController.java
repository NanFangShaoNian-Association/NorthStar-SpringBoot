package com.nfsn.controller.common;

import com.nfsn.model.dto.AddVideoRequest;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.model.vo.VideoVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/list")
    @ApiOperation("获取视频列表")
    public List<VideoListVO> list(){
        return null;
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
