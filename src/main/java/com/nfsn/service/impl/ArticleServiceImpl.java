package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ArticleMapper;
import com.nfsn.model.entity.Article;
import com.nfsn.service.ArticleService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【article】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {

}




