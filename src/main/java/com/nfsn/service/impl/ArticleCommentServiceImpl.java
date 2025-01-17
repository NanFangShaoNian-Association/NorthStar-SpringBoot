package com.nfsn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ArticleCommentMapper;
import com.nfsn.model.entity.ArticleComment;
import com.nfsn.model.entity.Goods;
import com.nfsn.model.entity.VideoComment;
import com.nfsn.service.ArticleCommentService;
import com.nfsn.utils.CacheClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.nfsn.constants.RedisConstants.*;

/**
* @author Tuanzi
* @description 针对表【article_comment】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class ArticleCommentServiceImpl extends ServiceImpl<ArticleCommentMapper, ArticleComment>
implements ArticleCommentService{

    @Resource
    private CacheClient cacheClient;

    @Resource
    private ArticleCommentMapper articleCommentMapper;

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

    /**
     * 通过文章id查询文章评论
     * @param articleId
     * @return
     */
    @Override
    public List<ArticleComment> getArticleCommentById(String articleId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("article_id",articleId);
        List<ArticleComment> articleCommentList = articleCommentMapper.selectByMap(map);
        return articleCommentList;
    }
}
