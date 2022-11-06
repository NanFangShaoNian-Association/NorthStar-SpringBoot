package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.ArticleCollectionMapper;
import com.nfsn.model.entity.ArticleCollection;
import com.nfsn.service.ArticleCollectionService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【article_collection】的数据库操作Service实现
* @createDate 2022-10-30 21:44:06
*/
@Service
public class ArticleCollectionServiceImpl extends ServiceImpl<ArticleCollectionMapper, ArticleCollection>
implements ArticleCollectionService{

}
