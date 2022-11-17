package com.nfsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ArticleCommentMapper;
import com.nfsn.model.entity.ArticleComment;
import com.nfsn.service.ArticleCommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【article_comment】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment>
implements ArticleCommentService{

    /**
     * 根据文章id查询该文章对应的评论
     *
     * @param articleId 文章id
     * @return 评论列表
     */
    @Override
    public List<ArticleComment> listByArticleId(Integer articleId) {
        return this.list(new LambdaQueryWrapper<ArticleComment>().eq(ArticleComment::getArticleId, articleId));
    }
}
