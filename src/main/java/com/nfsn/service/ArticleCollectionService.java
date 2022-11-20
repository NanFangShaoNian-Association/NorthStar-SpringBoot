package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.entity.ArticleCollection;

/**
* @author Tuanzi
* @description 针对表【article_collection】的数据库操作Service
* @createDate 2022-10-30 21:44:06
*/
public interface ArticleCollectionService extends IService<ArticleCollection> {

    /**
     * 收藏文章
     *
     * @param id 收藏用户的id
     * @param articleId 文章id
     */
    void collectionArticle(Integer id, Integer articleId);

    /**
     * 删除收藏的文章
     *
     * @param id 收藏用户的id
     * @param articleId 文章id
     */
    void deleteCollectionArticle(Integer id, Integer articleId);
}
