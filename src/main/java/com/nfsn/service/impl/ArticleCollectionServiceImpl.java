package com.nfsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserArticleException;
import com.nfsn.mapper.ArticleCollectionMapper;
import com.nfsn.model.entity.ArticleCollection;
import com.nfsn.service.ArticleCollectionService;
import com.nfsn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【article_collection】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class ArticleCollectionServiceImpl extends ServiceImpl<ArticleCollectionMapper, ArticleCollection>
implements ArticleCollectionService{
    private ArticleService articleService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 收藏文章
     *
     * @param id 收藏用户的id
     * @param articleId 文章id
     */
    @Override
    public void collectionArticle(Integer id, Integer articleId) {
        try {
            //检查视频是否存在
            if (articleService.getArticleById(String.valueOf(articleId)) == null){
                throw new UserArticleException(ResultCode.USER_ARTICLE_NOT_EXISTED);
            }
            //检查是否已收藏
            ArticleCollection collection = this.getOne(new LambdaQueryWrapper<ArticleCollection>()
                    .eq(ArticleCollection::getUserId, id)
                    .eq(ArticleCollection::getArticleId, articleId));
            if (collection != null){
                throw new UserArticleException(ResultCode.USER_COLLECTION_HAS_EXISTED);
            }
            ArticleCollection articleCollection = new ArticleCollection();
            articleCollection.setUserId(id);
            articleCollection.setArticleId(articleId);
            articleCollection.setDeleted(0);//未删除
            articleCollection.setCreateTime(new Date());

            this.save(articleCollection);
        } catch (UserArticleException e) {
            log.error("collectionArticle error:{}",e);
            throw e;
        } catch (Exception e) {
            log.error("collectionArticle error:{}",e);
            throw new UserArticleException(ResultCode.USER_COLLECTION_FAIL);
        }
    }

    /**
     * 删除收藏的文章
     *
     * @param id 收藏用户的id
     * @param articleId 文章id
     */
    @Override
    public void deleteCollectionArticle(Integer id, Integer articleId) {
        try {
            //检查是否已收藏
            ArticleCollection collection = this.getOne(new LambdaQueryWrapper<ArticleCollection>()
                    .eq(ArticleCollection::getUserId, id)
                    .eq(ArticleCollection::getArticleId, articleId));
            if (collection == null){
                throw new UserArticleException(ResultCode.USER_COLLECTION_NOT_EXISTED);
            }
            this.update(new LambdaUpdateWrapper<ArticleCollection>()
                    .eq(ArticleCollection::getUserId,id)
                    .eq(ArticleCollection::getId,articleId)
                    .set(ArticleCollection::getDeleted, 1));//已删除
        } catch (UserArticleException e) {
            log.error("deleteCollectionArticle error:{}",e);
            throw e;
        } catch (Exception e) {
            log.error("deleteCollectionArticle error:{}",e);
            throw new UserArticleException(ResultCode.USER_COLLECTION_FAIL);
        }
    }

    /**
     * 根据用户id查询收藏的文章列表
     *
     * @param id 用户id
     * @return 收藏的文章列表
     */
    @Override
    public List<ArticleCollection> listByUserId(Integer id) {
        return this.list(new LambdaQueryWrapper<ArticleCollection>().eq(ArticleCollection::getUserId, id).eq(ArticleCollection::getDeleted,0));
    }
}
