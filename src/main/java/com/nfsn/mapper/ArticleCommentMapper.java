package com.nfsn.mapper;

import com.nfsn.model.entity.ArticleComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nfsn.model.vo.ArticleCommentVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
* @author Tuanzi
* @description 针对表【article_comment】的数据库操作Mapper
* @createDate 2022-10-30 21:44:06
* @Entity com.nfsn.model.entity.com.nfsn.model.entity.ArticleComment
*/

public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {

}
