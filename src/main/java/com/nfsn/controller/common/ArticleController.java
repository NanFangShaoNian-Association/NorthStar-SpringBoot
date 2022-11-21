package com.nfsn.controller.common;

import com.nfsn.model.dto.AddArticleRequest;
import com.nfsn.model.entity.Article;
import com.nfsn.model.entity.Video;
import com.nfsn.model.vo.ArticleCommentVO;
import com.nfsn.model.vo.ArticleListVO;
import com.nfsn.model.vo.ArticleVO;
import com.nfsn.model.vo.VideoListVO;
import com.nfsn.service.ArticleService;
import com.nfsn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UserArticleController
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:11
 * @Description: 文章操作类
 */
@RestController
@RequestMapping("/articles")
@Api("文章操作类")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @Resource
    private UserService userService;

    /**
     * 获取文章列表
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("获取文章列表")
    public List<ArticleListVO> list(){
        List<ArticleListVO> articleListVOList = new ArrayList<>();

        List<Article> articleList = articleService.getArticleList();

        // 将articleList封装入articleListVOList中
        for (int i = 0; i < articleList.size(); i++) {
            ArticleListVO articleListVO = new ArticleListVO();
            Article article = articleList.get(i);
            BeanUtils.copyProperties(article,articleListVO);
            articleListVOList.add(articleListVO);
            // 根据用户id，从用户表中获取用户名，并封装入articleListVOList中
            articleListVOList.get(i).setUserName(userService.getUserNameById(articleList.get(i).getUserId()));
        }

        return articleListVOList;
    }

    /**
     * 获取文章详情
     * @param articleId
     * @return
     */
    @GetMapping("/getArticle/{articleId}")
    @ApiOperation("获取文章详情")
    public ArticleVO getArticle(@PathVariable("articleId") String articleId){

        ArticleVO articleVO = new ArticleVO();

        Article article = articleService.getArticleById(articleId);

        List<ArticleCommentVO> articleCommentVOS = new ArrayList<>();

        BeanUtils.copyProperties(article,articleVO);
        // 根据用户id，从用户表中获取用户名，并封装入articleVO中
        articleVO.setUserName(userService.getUserNameById(article.getUserId()));
        // 根据文章id，从article_comment表中获取所有这篇文章的评论，并封装入articleVO中


        return articleVO;
    }

    @PostMapping("/addArticle")
    @ApiOperation("发布文章")
    public void addArticle(@RequestBody AddArticleRequest addArticleRequest){
    }

}
