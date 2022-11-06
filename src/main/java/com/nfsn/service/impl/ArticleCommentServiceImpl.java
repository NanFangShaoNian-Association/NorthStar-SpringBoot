package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ArticleCommentMapper;
import com.nfsn.model.entity.ArticleComment;
import com.nfsn.service.ArticleCommentService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【article_comment】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment>
implements ArticleCommentService{

}
