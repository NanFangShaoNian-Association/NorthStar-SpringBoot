package com.nfsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserVideoException;
import com.nfsn.mapper.VideoMapper;
import com.nfsn.model.entity.Video;
import com.nfsn.service.VideoService;
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
     * 根据用户id查询视频列表
     *
     * @param id 用户id
     * @return 视频列表
     */
    @Override
    public List<Video> listByUserId(Integer id) {
        return this.list(new LambdaQueryWrapper<Video>().eq(Video::getUserId, id));
    }

    /**
     * 获取视频
     * @return
     */
    @Override
    public List<Video> getVideoList() {
        List<Video> videoList = videoMapper.selectList(null);
        return videoList;
    }

    @Override
    public Video getVideoById(String videoId) {
        return videoMapper.selectById(videoId);
    }

    /**
     * 根据用户id确认该视频是否为自己的，再根据视频id删除该视频
     *
     * @param userId 用户id
     * @param videoId 视频id
     */
    @Override
    public void deleteVideoById(Integer userId, Integer videoId) {
        try {
            this.remove(new LambdaQueryWrapper<Video>()
                    .eq(Video::getUserId,userId)
                    .eq(Video::getId,videoId));
        } catch (Exception e) {
            log.error("deleteVideoById error:{}",e);
            throw new UserVideoException(ResultCode.USER_VIDEO_DELETE_FAIL);
        }
    }
}




