package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nfsn.exception.UserArticleException;
import com.nfsn.model.dto.AddArticleRequest;
import com.nfsn.model.entity.Article;
import com.nfsn.model.entity.ArticleCollection;
import com.nfsn.model.entity.ArticleComment;
import com.nfsn.model.entity.User;
import com.nfsn.model.vo.ArticleCommentVO;
import com.nfsn.model.vo.ArticleListVO;
import com.nfsn.model.vo.ArticleVO;
import com.nfsn.service.ArticleCollectionService;
import com.nfsn.service.ArticleCommentService;
import com.nfsn.service.ArticleService;
import com.nfsn.utils.AccountHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    private ArticleCommentService articleCommentService;

    @Resource
    private ArticleCollectionService articleCollectionService;

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
            //内容（截取一段，两行，暂定两行字符数为18）
            String content = articleListVOS.get(i).getArticleContent();
            articleListVOS.get(i).setArticleContent( content.length() < 18 ? content : content.substring(0, 18));
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
        //转换图片列表
        articleVO.setImages(StrUtil.split(article.getArticleUrl(), "|"));
//            articleVO.setIntroduction();//数据库暂无此字段
        return articleVO;
    }

    /**
     * 发布文章
     *
     * @param addArticleRequest 添加文章请求实体
     */
    public void addArticle(AddArticleRequest addArticleRequest) {
        User user = AccountHolder.getUser();
        Article article = BeanUtil.copyProperties(addArticleRequest, Article.class);
        //转换图片列表为字符串，以|为分隔符
        String imageUrl = addArticleRequest.getImagesUrl().stream().collect(Collectors.joining("|"));

        //补全所有的值
        article.setCreateTime(new Date());
        article.setUserId(user.getId());
        article.setLikeCount(0);
        article.setCollectionCount(0);
        article.setArticleUrl(imageUrl);
        try {
            //保存文章
            articleService.save(article);
        } catch (Exception e) {
            e.printStackTrace();
            //发布失败，抛出异常
            throw new UserArticleException(USER_ARTICLE_PUBLISH_FAIL);
        }
    }

    /**
     * 删除文章
     *
     * @param articleId 文章Id
     */
    public void deleteArticle(Integer articleId) {
        User user = AccountHolder.getUser();
        //根据用户id确认该文章是否为自己的，再根据文章id删除该文章
        articleService.deleteArticleById(user.getId(), articleId);
    }

    /**
     * 获取收藏的文章列表
     *
     * @return 收藏的文章列表
     */
    public List<ArticleListVO> collectionList() {
        User user = AccountHolder.getUser();
        //根据用户id查询文章列表
        List<ArticleCollection> articleCollectionList = articleCollectionService.listByUserId(user.getId());
        //获取不重复的id
        List<Integer> ids = articleCollectionList.stream().map(ArticleCollection::getArticleId).distinct().collect(Collectors.toList());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();

        //拼接所有文章id
        ids.stream().forEach(id -> queryWrapper.or().eq(Article::getId,id));

        //根据文章id获取所有的文章
        List<Article> articleList = articleService.list(queryWrapper);

        List<ArticleListVO> articleListVOS = BeanUtil.copyToList(articleList, ArticleListVO.class);
        //补全所有的值
        for (int i = 0; i < articleListVOS.size(); i++) {
            articleListVOS.get(i).setUserName(user.getUserName());
        }
        log.info("文章响应列表实体为：{}",articleListVOS);
        return articleListVOS;
    }

    /**
     * 收藏文章
     *
     * @param articleId 文章Id
     */
    public void collectionArticle(Integer articleId) {
        User user = AccountHolder.getUser();
        //收藏文章
        articleCollectionService.collectionArticle(user.getId(), articleId);
    }

    /**
     * 删除收藏的文章
     *
     * @param articleId 文章Id
     */
    public void deleteCollectionArticle(Integer articleId) {
        User user = AccountHolder.getUser();
        //删除收藏的文章
        articleCollectionService.deleteCollectionArticle(user.getId(), articleId);
    }


}
