package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nfsn.exception.UserVideoException;
import com.nfsn.model.dto.AddVideoRequest;
import com.nfsn.model.entity.*;
import com.nfsn.model.vo.VideoCommentVO;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.model.vo.VideoVO;
import com.nfsn.service.VideoCollectionService;
import com.nfsn.service.VideoCommentService;
import com.nfsn.service.VideoService;
import com.nfsn.utils.AccountHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.nfsn.constants.ResultCode.USER_VIDEO_PUBLISH_FAIL;

/**
 * @ClassName: UserVideoServiceImpl
 * @Author: 团子tz
 * @CreateTime: 2022/11/22 22:59
 * @Description: 用户自己的视频操作类
 */
@Service("userVideoService")
@Slf4j
public class UserVideoServiceImpl {
    @Resource
    private VideoService videoService;

    @Resource
    private VideoCommentService videoCommentService;

    @Resource
    private VideoCollectionService videoCollectionService;

    /**
     * 获取视频列表
     *
     * @return 视频列表
     */
    public List<VideoListVO> list() {
        User user = AccountHolder.getUser();
        //根据用户id查询视频列表
        List<Video> videoList = videoService.listByUserId(user.getId());
        List<VideoListVO> videoListVOS = BeanUtil.copyToList(videoList, VideoListVO.class);
        //补全所有的值
        for (int i = 0; i < videoListVOS.size(); i++) {
            videoListVOS.get(i).setUserName(user.getUserName());
        }
        log.info("视频响应列表实体为：{}",videoListVOS);
        return videoListVOS;
    }

    /**
     * 获取视频详情
     *
     * @param videoId 视频Id
     * @return 视频详情
     */
    public VideoVO getVideo(Integer videoId) {
        User user = AccountHolder.getUser();
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Video::getId, videoId).eq(Video::getUserId,user.getId());
        //查询视频
        Video video = videoService.getOne(queryWrapper);
        //查询该视频对应的评论
        List<VideoComment> videoComments = videoCommentService.listByVideoId(videoId);
        //复制可以映射的属性
        VideoVO videoVO = BeanUtil.copyProperties(video, VideoVO.class);
        List<VideoCommentVO> videoCommentsVO = BeanUtil.copyToList(videoComments, VideoCommentVO.class);
        //补全所有的值
        videoVO.setUserName(user.getUserName());
        videoVO.setComments(videoCommentsVO);
        videoVO.setCommentCount(videoCommentsVO.size());
//            videoVO.setIntroduction();//数据库暂无此字段
        return videoVO;
    }

    /**
     * 发布视频
     *
     * @param addVideoRequest 添加视频请求实体
     */
    public void addVideo(AddVideoRequest addVideoRequest) {
        User user = AccountHolder.getUser();
        Video video = BeanUtil.copyProperties(addVideoRequest, Video.class);

        //补全所有的值
        video.setUserId(user.getId());
        video.setLikeCount(0);
        video.setCollectionCount(0);
        video.setCreateTime(new Date());
        try {
            //保存视频
            videoService.save(video);
        } catch (Exception e) {
            e.printStackTrace();
            //发布失败，抛出异常
            throw new UserVideoException(USER_VIDEO_PUBLISH_FAIL);
        }
    }

    /**
     * 删除视频
     *
     * @param videoId 视频Id
     */
    public void deleteVideo(Integer videoId) {
        User user = AccountHolder.getUser();
        //根据用户id确认该视频是否为自己的，再根据视频id删除该视频
        videoService.deleteVideoById(user.getId(), videoId);
    }

    /**
     * 获取收藏的视频列表
     *
     * @return 收藏的视频列表
     */
    public List<VideoListVO> collectionList() {
        User user = AccountHolder.getUser();
        //根据用户id查询视频列表
        List<VideoCollection> videoCollectionList = videoCollectionService.listByUserId(user.getId());
        //获取不重复的id
        List<Integer> ids = videoCollectionList.stream().map(VideoCollection::getVideoId).distinct().collect(Collectors.toList());
        LambdaQueryWrapper<Video> queryWrapper = new LambdaQueryWrapper<>();

        //拼接所有视频id
        ids.stream().forEach(id -> queryWrapper.or().eq(Video::getId,id));

        //根据视频id获取所有的视频
        List<Video> videoList = videoService.list(queryWrapper);

        List<VideoListVO> videoListVOS = BeanUtil.copyToList(videoList, VideoListVO.class);
        //补全所有的值
        for (int i = 0; i < videoListVOS.size(); i++) {
            videoListVOS.get(i).setUserName(user.getUserName());
        }
        log.info("视频响应列表实体为：{}",videoListVOS);
        return videoListVOS;
    }

    /**
     * 收藏视频
     *
     * @param videoId 视频Id
     */
    public void collectionVideo(Integer videoId) {
        User user = AccountHolder.getUser();
        //收藏视频
        videoCollectionService.collectionVideo(user.getId(), videoId);
    }

    /**
     * 删除收藏的视频
     *
     * @param videoId 视频Id
     */
    public void deleteCollectionVideo(Integer videoId) {
        User user = AccountHolder.getUser();
        //删除收藏的视频
        videoCollectionService.deleteCollectionVideo(user.getId(), videoId);
    }
}
