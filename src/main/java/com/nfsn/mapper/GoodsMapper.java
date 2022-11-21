package com.nfsn.mapper;

import com.nfsn.model.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfsn.model.vo.GoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.Mapping;

/**
* @author Tuanzi
* @description 针对表【goods】的数据库操作Mapper
* @createDate 2022-10-30 21:44:06
* @Entity com.nfsn.model.entity.com.nfsn.model.entity.Goods
*/
public interface GoodsMapper extends BaseMapper<Goods> {

}
