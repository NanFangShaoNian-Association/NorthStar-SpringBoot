package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nfsn.exception.UserArticleException;
import com.nfsn.model.dto.AddArticleRequest;
import com.nfsn.model.entity.Article;
import com.nfsn.model.entity.ArticleComment;
import com.nfsn.model.entity.User;
import com.nfsn.model.vo.ArticleCommentVO;
import com.nfsn.model.vo.ArticleListVO;
import com.nfsn.model.vo.ArticleVO;
import com.nfsn.service.ArticleCommentService;
import com.nfsn.service.ArticleService;
import com.nfsn.service.UserService;
import com.nfsn.utils.AccountHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.nfsn.constants.ResultCode.USER_ARTICLE_PUBLISH_FAIL;

/**
 * @ClassName: UserArticleServiceImpl
 * @Author: 团子tz
 * @CreateTime: 2022/11/17 20:51
 * @Description: 用户自己的文章操作类
 */
@Service("userArticleService")
@Slf4j
public class UserArticleServiceImpl {
    @Resource
    private ArticleService articleService;
    @Resource
    private UserService userService;
    @Resource
    private ArticleCommentService articleCommentService;

    /**
     * 获取文章列表
     *
     * @return 文章列表
     */
    public List<ArticleListVO> list() {
        User user = AccountHolder.getUser();
        //根据用户id查询文章列表
        List<Article> articleList = articleService.listByUserId(user.getId());
        List<ArticleListVO> articleListVOS = BeanUtil.copyToList(articleList, ArticleListVO.class);
        //补全所有的值
        for (int i = 0; i < articleListVOS.size(); i++) {
            articleListVOS.get(i).setUserName(user.getUserName());
        }
        log.info("文章响应列表实体为：{}",articleListVOS);
        return articleListVOS;
    }

    /**
     * 获取文章详情
     *
     * @param articleId 文章Id
     * @return 文章详情
     */
    public ArticleVO getArticle(Integer articleId) {
        User user = AccountHolder.getUser();
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Article::getId, articleId).eq(Article::getUserId,user.getId());
        //查询文章
        Article article = articleService.getOne(queryWrapper);
        //查询该文章对应的评论
        List<ArticleComment> articleComments = articleCommentService.listByArticleId(articleId);
        //复制可以映射的属性
        ArticleVO articleVO = BeanUtil.copyProperties(article, ArticleVO.class);
        List<ArticleCommentVO> articleCommentsVO = BeanUtil.copyToList(articleComments, ArticleCommentVO.class);
        //补全所有的值
        articleVO.setUserName(user.getUserName());
        articleVO.setComments(articleCommentsVO);
        articleVO.setCommentCount(articleCommentsVO.size());
//            articleVO.setIntroduction();//数据库暂无此字段
        return articleVO;
    }

    /**
     * 发布文章
     *
     * @param addArticleRequest 添加文章请求实体
     */
    public void getArticle(AddArticleRequest addArticleRequest) {
        User user = AccountHolder.getUser();
        Article article = BeanUtil.copyProperties(addArticleRequest, Article.class);
        //补全所有的值
        article.setUserId(user.getId());
        article.setLikeCount(0);
        article.setCollectionCount(0);
        try {
            articleService.save(article);
        } catch (Exception e) {
            e.printStackTrace();
            //发布失败，抛出异常
            throw new UserArticleException(USER_ARTICLE_PUBLISH_FAIL);
        }
    }
}
