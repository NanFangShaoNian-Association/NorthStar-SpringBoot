package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.ArticleComment;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【article_comment】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface ArticleCommentService extends IService<ArticleComment> {

    /**
     * 根据文章id查询该文章对应的评论
     *
     * @param articleId 文章id
     * @return 评论列表
     */
    List<ArticleComment> listByArticleId(Integer articleId);

    List<ArticleComment> getArticleCommentById(String articleId);
}
