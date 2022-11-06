package com.nfsn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.PetMapper;
import com.nfsn.model.entity.Pet;
import com.nfsn.service.PetService;
import org.springframework.stereotype.Service;

/**
* @author Tuanzi
* @description 针对表【pet】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet>
    implements PetService {

}




