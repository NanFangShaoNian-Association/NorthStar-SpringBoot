package com.nfsn.controller.common;

import com.nfsn.model.dto.AddArticleRequest;
import com.nfsn.model.vo.ArticleListVO;
import com.nfsn.model.vo.ArticleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/list")
    @ApiOperation("获取文章列表")
    public List<ArticleListVO> list(){
        return null;
    }

    @GetMapping("/getArticle/{articleId}")
    @ApiOperation("获取文章详情")
    public ArticleVO getArticle(@PathVariable("articleId") String articleId){
        return null;
    }

    @PostMapping("/addArticle")
    @ApiOperation("发布文章")
    public void addArticle(@RequestBody AddArticleRequest addArticleRequest){
    }

}
