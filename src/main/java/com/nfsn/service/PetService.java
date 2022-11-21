package com.nfsn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nfsn.model.dto.PetVO;
import com.nfsn.model.dto.UpdatePetRequest;
import com.nfsn.model.entity.Pet;
import com.nfsn.model.vo.PetsListVO;

import java.util.List;

/**
* @author Tuanzi
* @description 针对表【pet】的数据库操作Service
* @createDate 2022-11-03 22:17:40
*/
public interface PetService extends IService<Pet> {

    /**
     * 获取宠物列表
     *
     * @return 宠物信息列表
     */
    List<PetsListVO> listPets();

    /**
     * 获取宠物详细信息
     *
     * @param petId 宠物id
     * @return 宠物详细信息
     */
    PetVO getPet(Integer petId);

    /**
     * 编辑宠物信息、新增宠物信息（编辑存在宠物id，新增宠物id为空）
     *
     * @param updatePetRequest 宠物详细信息
     */
    void updatePet(UpdatePetRequest updatePetRequest);
}
