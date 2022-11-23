package com.nfsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserVideoException;
import com.nfsn.mapper.VideoCollectionMapper;
import com.nfsn.model.entity.VideoCollection;
import com.nfsn.service.VideoCollectionService;
import com.nfsn.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【video_collection】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class VideoCollectionServiceImpl extends ServiceImpl<VideoCollectionMapper, VideoCollection>
implements VideoCollectionService{
    private VideoService videoService;

    @Autowired
    public void setVideoService(VideoService videoService) {
        this.videoService = videoService;
    }

    /**
     * 收藏视频
     *
     * @param id 收藏用户的id
     * @param videoId 视频id
     */
    @Override
    public void collectionVideo(Integer id, Integer videoId) {
        try {
            //检查视频是否存在
            if (videoService.getVideoById(String.valueOf(videoId)) == null){
                throw new UserVideoException(ResultCode.USER_VIDEO_NOT_EXISTED);
            }
            //检查是否已收藏
            VideoCollection collection = this.getOne(new LambdaQueryWrapper<VideoCollection>()
                    .eq(VideoCollection::getUserId, id)
                    .eq(VideoCollection::getVideoId, videoId));
            if (collection != null){
                throw new UserVideoException(ResultCode.USER_COLLECTION_HAS_EXISTED);
            }
            VideoCollection videoCollection = new VideoCollection();
            videoCollection.setUserId(id);
            videoCollection.setVideoId(videoId);
            videoCollection.setDeleted(0);//未删除
            videoCollection.setCreateTime(new Date());

            this.save(videoCollection);
        } catch (UserVideoException e) {
            log.error("collectionVideo error:{}",e);
            throw e;
        } catch (Exception e) {
            log.error("collectionVideo error:{}",e);
            throw new UserVideoException(ResultCode.USER_COLLECTION_FAIL);
        }
    }

    /**
     * 删除收藏的视频
     *
     * @param id 收藏用户的id
     * @param videoId 视频id
     */
    @Override
    public void deleteCollectionVideo(Integer id, Integer videoId) {
        try {
            //检查是否已收藏
            VideoCollection collection = this.getOne(new LambdaQueryWrapper<VideoCollection>()
                    .eq(VideoCollection::getUserId, id)
                    .eq(VideoCollection::getVideoId, videoId));
            if (collection == null){
                throw new UserVideoException(ResultCode.USER_COLLECTION_NOT_EXISTED);
            }
            this.update(new LambdaUpdateWrapper<VideoCollection>()
                    .eq(VideoCollection::getUserId,id)
                    .eq(VideoCollection::getId,videoId)
                    .set(VideoCollection::getDeleted, 1));//已删除
        } catch (UserVideoException e) {
            log.error("deleteCollectionVideo error:{}",e);
            throw e;
        } catch (Exception e) {
            log.error("deleteCollectionVideo error:{}",e);
            throw new UserVideoException(ResultCode.USER_COLLECTION_FAIL);
        }
    }

    /**
     * 根据用户id查询收藏的视频列表
     *
     * @param id 用户id
     * @return 收藏的视频列表
     */
    @Override
    public List<VideoCollection> listByUserId(Integer id) {
        return this.list(new LambdaQueryWrapper<VideoCollection>()
                .eq(VideoCollection::getUserId, id)
                .eq(VideoCollection::getDeleted,0));
    }
}
