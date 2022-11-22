package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.VideoCollection;

import java.util.List;


/**
* @author Tuanzi
* @description 针对表【video_collection】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface VideoCollectionService extends IService<VideoCollection> {
    /**
     * 收藏视频
     *
     * @param id 收藏用户的id
     * @param videoId 视频id
     */
    void collectionVideo(Integer id, Integer videoId);

    /**
     * 删除收藏的视频
     *
     * @param id 收藏用户的id
     * @param videoId 视频id
     */
    void deleteCollectionVideo(Integer id, Integer videoId);

    /**
     * 根据用户id查询收藏的视频列表
     *
     * @param id 用户id
     * @return 收藏的视频列表
     */
    List<VideoCollection> listByUserId(Integer id);

}
