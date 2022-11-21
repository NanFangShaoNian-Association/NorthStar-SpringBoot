package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.PetMapper;
import com.nfsn.model.dto.PetVO;
import com.nfsn.model.dto.UpdatePetRequest;
import com.nfsn.model.entity.Pet;
import com.nfsn.model.entity.User;
import com.nfsn.model.vo.PetsListVO;
import com.nfsn.service.PetService;
import com.nfsn.service.PetVarietyService;
import com.nfsn.utils.AccountHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author Tuanzi
* @description 针对表【pet】的数据库操作Service实现
* @createDate 2022-11-03 22:17:40
*/
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet>
    implements PetService {
    @Resource
    private PetVarietyService petVarietyService;

    /**
     * 获取宠物列表
     *
     * @return 宠物信息列表
     */
    @Override
    public List<PetsListVO> listPets() {
        User user = AccountHolder.getUser();
        //获取宠物列表信息
        List<Pet> petList = this.list(new LambdaQueryWrapper<Pet>().eq(Pet::getMasterId, user.getId()));
        List<PetsListVO> petsListVOS = BeanUtil.copyToList(petList, PetsListVO.class);
        //获取不重复的id
        List<Integer> ids = petList.stream().map(Pet::getPetVarietyId).distinct().collect(Collectors.toList());
        //根据宠物id获取所有的宠物品种名，k为id，v为宠物品种
//        Map<Integer, String> petVarieties = petVarietyService.getPetVarietyByIds(ids);
//        //填充宠物品种名
//        int count = 0;
//        petsListVOS = petsListVOS.stream().map(petsListVO -> {
//            petsListVO.setPetVariety(petVarieties.get(petList.get(count).getPetVarietyId()));
//            count = count + 1;
//            return petsListVO;
//        })
        return petsListVOS;
    }

    /**
     * 获取宠物详细信息
     *
     * @param petId 宠物id
     * @return 宠物详细信息
     */
    @Override
    public PetVO getPet(Integer petId) {
        return null;
    }

    /**
     * 编辑宠物信息、新增宠物信息（编辑存在宠物id，新增宠物id为空）
     *
     * @param updatePetRequest 宠物详细信息
     */
    @Override
    public void updatePet(UpdatePetRequest updatePetRequest) {

    }
}




