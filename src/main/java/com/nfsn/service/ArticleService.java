package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.Article;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【article】的数据库操作Service
* @createDate 2022-11-03 22:17:40
*/
public interface ArticleService extends IService<Article> {

    /**
     * 根据用户id查询文章列表
     *
     * @param id 用户id
     * @return 文章列表
     */
    List<Article> listByUserId(Integer id);

    List<Article> getArticleList();

    Article getArticleById(String articleId);

    /**
     * 根据用户id确认该文章是否为自己的，再根据文章id删除该文章
     *
     * @param userId 用户id
     * @param articleId 文章id
     */
    void deleteArticleById(Integer userId, Integer articleId);
}
