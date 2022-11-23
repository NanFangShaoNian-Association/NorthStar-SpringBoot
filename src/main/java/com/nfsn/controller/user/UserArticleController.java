package com.nfsn.controller.user;

import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserArticleException;
import com.nfsn.model.dto.AddArticleRequest;
import com.nfsn.model.vo.ArticleListVO;
import com.nfsn.model.vo.ArticleVO;
import com.nfsn.service.impl.UserArticleServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserArticleController
 * @Author: 团子tz
 * @CreateTime: 2022/11/04 01:11
 * @Description: 用户自己的文章操作类
 */
@RestController
@RequestMapping("/users/articles")
@Api("用户自己的文章操作类")
public class UserArticleController {
    @Resource(name = "userArticleService")
    private UserArticleServiceImpl userArticleService;

    @GetMapping("/list")
    @ApiOperation("获取文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public List<ArticleListVO> list(){
        return userArticleService.list();
    }

    @GetMapping("/getArticle/{articleId}")
    @ApiOperation("获取文章详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public ArticleVO getArticle(@PathVariable("articleId") String articleId){
        Integer value = 0;
        try {
            value = Integer.valueOf(articleId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new UserArticleException(ResultCode.PARAM_IS_INVALID);
        }
        return userArticleService.getArticle(value);
    }

    @PostMapping("/addArticle")
    @ApiOperation("发布文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void addArticle(@RequestBody AddArticleRequest addArticleRequest){
        userArticleService.addArticle(addArticleRequest);
    }

    @DeleteMapping("/deleteArticle/{articleId}")
    @ApiOperation("删除文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void deleteArticle(@PathVariable("articleId") String articleId){
        Integer value = 0;
        try {
            value = Integer.valueOf(articleId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new UserArticleException(ResultCode.PARAM_IS_INVALID);
        }
        userArticleService.deleteArticle(value);
    }

    @GetMapping("/collectionList")
    @ApiOperation("获取收藏文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public List<ArticleListVO> collectionList(){
        return userArticleService.collectionList();
    }

    @PostMapping("/collectionArticle/{articleId}")
    @ApiOperation("收藏文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void collectionArticle(@PathVariable("articleId") String articleId){
        Integer value = 0;
        try {
            value = Integer.valueOf(articleId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new UserArticleException(ResultCode.PARAM_IS_INVALID);
        }
        userArticleService.collectionArticle(value);
    }

    @DeleteMapping("/deleteCollectionArticle/{articleId}")
    @ApiOperation("删除收藏的文章")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void deleteCollectionArticle(@PathVariable("articleId") String articleId){
        Integer value = 0;
        try {
            value = Integer.valueOf(articleId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new UserArticleException(ResultCode.PARAM_IS_INVALID);
        }
        userArticleService.deleteCollectionArticle(value);
    }

}
