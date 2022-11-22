package com.nfsn.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nfsn.mapper.PetMapper;
import com.nfsn.model.dto.PetVO;
import com.nfsn.model.dto.UpdatePetRequest;
import com.nfsn.model.entity.Pet;
import com.nfsn.model.entity.PetVariety;
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

        //获取不重复的宠物品种id
        List<Integer> ids = petList.stream().map(Pet::getPetVarietyId).distinct().collect(Collectors.toList());
        //拼接所有宠物品种id
        LambdaQueryWrapper<PetVariety> queryWrapper = new LambdaQueryWrapper<>();
        ids.stream().forEach(id -> queryWrapper.or().eq(PetVariety::getId,id));
        //查询获取宠物品种名
        List<PetVariety> petVarieties = petVarietyService.list(queryWrapper);
        //填充宠物品种名
        List<PetsListVO> petsListVOS = BeanUtil.copyToList(petList, PetsListVO.class);

//        int count = 0;
//        for (int i = 0; i < petsListVOS.size(); i++) {
//            petList.get(i).getPetVarietyId();
//            petsListVOS.get(i).setPetVariety();
//        }
//        petsListVOS = petsListVOS.stream().flatMap(petsListVO -> {
//            petsListVO.setPetVariety(petVarieties.);
//            return petsListVO;
//        }).collect(Collectors.toList());
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




