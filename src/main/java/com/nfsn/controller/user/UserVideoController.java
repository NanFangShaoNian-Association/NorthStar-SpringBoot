package com.nfsn.controller.user;

import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserVideoException;
import com.nfsn.model.dto.AddVideoRequest;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.model.vo.VideoVO;
import com.nfsn.service.impl.UserVideoServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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
@Slf4j
public class UserVideoController {

    @Resource(name = "userVideoService")
    private UserVideoServiceImpl userVideoService;

    @GetMapping("/list")
    @ApiOperation("获取视频列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public List<VideoListVO> list(){
        return userVideoService.list();
    }

    @GetMapping("/getVideo/{videoId}")
    @ApiOperation("获取视频详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public VideoVO getVideo(@PathVariable("videoId") String videoId){
        Integer value = 0;
        try {
            value = Integer.valueOf(videoId);
        } catch (NumberFormatException e) {
            log.error("UserVideoController getVideo 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        return userVideoService.getVideo(value);
    }

    @PostMapping("/addVideo")
    @ApiOperation("发布视频")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void addVideo(@RequestBody AddVideoRequest addVideoRequest){
        userVideoService.addVideo(addVideoRequest);
    }

    @DeleteMapping("/deleteVideo/{videoId}")
    @ApiOperation("删除视频")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void deleteVideo(@PathVariable("videoId") String videoId){
        Integer value = 0;
        try {
            value = Integer.valueOf(videoId);
        } catch (NumberFormatException e) {
            log.error("UserVideoController deleteVideo 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        userVideoService.deleteVideo(value);
    }

    @GetMapping("/collectionList")
    @ApiOperation("获取收藏视频列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public List<VideoListVO> collectionList(){
        return userVideoService.collectionList();
    }

    @PostMapping("/collectionVideo/{videoId}")
    @ApiOperation("收藏视频")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void collectionVideo(@PathVariable("videoId") String videoId){
        Integer value = 0;
        try {
            value = Integer.valueOf(videoId);
        } catch (NumberFormatException e) {
            log.error("UserVideoController collectionArticle 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        userVideoService.collectionVideo(value);
    }

    @DeleteMapping("/deleteCollectionVideo/{videoId}")
    @ApiOperation("删除收藏的视频")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void deleteCollectionArticle(@PathVariable("videoId") String videoId){
        Integer value = 0;
        try {
            value = Integer.valueOf(videoId);
        } catch (NumberFormatException e) {
            log.error("UserVideoController deleteCollectionArticle 数值转换异常");
            throw new UserVideoException(ResultCode.PARAM_IS_INVALID);
        }
        userVideoService.deleteCollectionVideo(value);
    }
}