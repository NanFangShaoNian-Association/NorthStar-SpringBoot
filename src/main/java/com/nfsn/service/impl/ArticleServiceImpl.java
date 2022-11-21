package com.nfsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ArticleMapper;
import com.nfsn.model.entity.Article;
import com.nfsn.model.entity.Video;
import com.nfsn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* @author Tuanzi
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    /**
     * 根据用户id查询文章列表
     *
     * @param id 用户id
     * @return 文章列表
     */
    @Override
    public List<Article> listByUserId(Integer id) {
        return this.list(new LambdaQueryWrapper<Article>().eq(Article::getUserId, id));
    }

    @Override
    public List<Article> getArticleList() {
        return articleMapper.selectList(null);
    }

    /**
     * 根据文章id获取文章详细内容
     * @param articleId
     * @return
     */
    @Override
    public Article getArticleById(String articleId) {
        Article article = articleMapper.selectById(articleId);
        return article;
    }
}