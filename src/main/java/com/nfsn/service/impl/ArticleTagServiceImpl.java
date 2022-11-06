package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ArticleTagMapper;
import com.nfsn.model.entity.ArticleTag;
import com.nfsn.service.ArticleTagService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【article_tag】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class ArticleTagServiceImpl extends ServiceImpl<ArticleTagMapper, ArticleTag>
implements ArticleTagService{

}
