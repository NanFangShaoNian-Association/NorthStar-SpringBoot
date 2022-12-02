package com.nfsn.controller.user;

import cn.hutool.core.bean.BeanUtil;
import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserArticleException;
import com.nfsn.model.dto.PetVO;
import com.nfsn.model.dto.UpdatePetRequest;
import com.nfsn.model.vo.PetVarietyListVO;
import com.nfsn.model.vo.PetsListVO;
import com.nfsn.service.PetService;
import com.nfsn.service.PetVarietyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @Resource
    private PetVarietyService petVarietyService;

    //获取宠物列表
    @ApiOperation("获取宠物列表")
    @GetMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public List<PetsListVO> list() {
        return petService.listPets();
    }

    //获取宠物详细信息
    @ApiOperation("获取宠物详细信息")
    @GetMapping("/getPet/{petId}")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public void updatePet(@RequestBody UpdatePetRequest updatePetRequest) {
        petService.updatePet(updatePetRequest);
    }

    //获取宠物列表
    @ApiOperation("获取宠物品种")
    @GetMapping("/listPetVariety")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户身份令牌", dataType = "String", required = true)
    })
    public List<PetVarietyListVO> listPetVariety() {
        return BeanUtil.copyToList(petVarietyService.list(),PetVarietyListVO.class);
    }

}
