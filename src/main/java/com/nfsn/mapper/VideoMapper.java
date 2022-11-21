package com.nfsn.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfsn.model.entity.Video;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.model.vo.VideoVO;
//import org.mapstruct.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【video】的数据库操作Mapper
* @createDate 2022-11-03 22:17:40
* @Entity .domain.Video
*/
@Mapper
//@org.apache.ibatis.annotations.Mapper
public interface VideoMapper extends BaseMapper<Video> {

//    VideoMapper mapper = Mappers.getMapper(VideoMapper.class);
//    VideoListVO pojo2vo(Video video);
//    List<VideoListVO> list2vo(List<Video> list);

}