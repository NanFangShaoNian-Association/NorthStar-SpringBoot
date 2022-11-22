package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.Video;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【video】的数据库操作Service
* @createDate 2022-11-03 22:17:40
*/
public interface VideoService extends IService<Video> {
    /**
     * 根据用户id查询视频列表
     *
     * @param id 用户id
     * @return 视频列表
     */
    List<Video> listByUserId(Integer id);

    List<Video> getVideoList();

    Video getVideoById(String videoId);

    /**
     * 根据用户id确认该视频是否为自己的，再根据视频id删除该视频
     *
     * @param userId 用户id
     * @param videoId 视频id
     */
    void deleteVideoById(Integer userId, Integer videoId);
}
