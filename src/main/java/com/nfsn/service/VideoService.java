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

    List<Video> getVideoList();
}
