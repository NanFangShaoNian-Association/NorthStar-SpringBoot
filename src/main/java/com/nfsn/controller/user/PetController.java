package com.nfsn.controller.user;

import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserArticleException;
import com.nfsn.model.dto.PetVO;
import com.nfsn.model.dto.UpdatePetRequest;
import com.nfsn.model.vo.PetsListVO;
import com.nfsn.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: PetController
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 17:00
 * @Description: 用户端宠物操作类
 */
@RestController
@RequestMapping("/users/pets")
@Api("用户端宠物操作类")
@Slf4j
public class PetController {

    @Resource
    private PetService petService;

    //获取宠物列表
    @ApiOperation("获取宠物列表")
    @GetMapping("/list")
    public List<PetsListVO> list() {
        return petService.listPets();
    }

    //获取宠物详细信息
    @ApiOperation("获取宠物详细信息")
    @GetMapping("/getPet/{petId}")
    public PetVO getPet(@PathVariable("petId") String petId) {
        Integer value = 0;
        try {
            value = Integer.valueOf(petId);
        } catch (NumberFormatException e) {
            log.error("PetController getPet NumberFormatException : ", e);
            throw new UserArticleException(ResultCode.PARAM_IS_INVALID);
        }
        return petService.getPet(value);
    }

    //编辑宠物信息、新增宠物信息（编辑存在宠物id，新增宠物id为空）
    @ApiOperation("编辑宠物信息、新增宠物信息（编辑存在宠物id，新增宠物id为空）")
    @PostMapping("/updatePet")
    public void updatePet(@RequestBody UpdatePetRequest updatePetRequest) {
        petService.updatePet(updatePetRequest);
    }
}
