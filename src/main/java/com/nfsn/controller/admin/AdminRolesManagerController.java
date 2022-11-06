package com.nfsn.controller.admin;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nfsn.model.dto.OperateUserRequest;
import com.nfsn.model.dto.SearchRequest;
import com.nfsn.model.vo.GoodListVO;
import com.nfsn.model.vo.SearchAdminVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: AdminRolesManagerController
 * @Author: 团子tz
 * @CreateTime: 2022/10/31 15:22
 * @Description: 平台端用户管理操作类
 */
@RestController
@RequestMapping("/admin")
@Api("平台端用户管理操作类")
public class AdminRolesManagerController {

    //获取平台管理员列表
    @ApiOperation("获取平台管理员列表")
    @GetMapping("/admin/list/{adminId}")
    public List<GoodListVO> listAdmin(@PathVariable("adminId") Integer adminId) {
        return null;
    }

    //平台管理员搜索
    @ApiOperation("搜索平台管理员")
    @PostMapping("/admin/search")
    public Page<List<SearchAdminVO>> searchAdmin(@RequestBody SearchRequest searchRequest){
        return null;
    }


    //平台管理员 注销、封号、解冻
    @ApiOperation("操作平台管理员")
    @PutMapping("/admin/operate")
    public void operateAdmin(@RequestBody OperateUserRequest operateUserRequest){

    }


    //获取商家列表
    @ApiOperation("获取商家列表")
    @GetMapping("/merchant/list/{adminId}")
    public List<GoodListVO> listMerchant(@PathVariable("adminId") Integer adminId) {
        return null;
    }

    //商家搜索
    @ApiOperation("搜索商家")
    @PostMapping("/merchant/search")
    public Page<List<SearchAdminVO>> searchMerchant(@RequestBody SearchRequest searchRequest){
        return null;
    }

    //商家 注销、封号、解冻
    @ApiOperation("操作商家")
    @PutMapping("/merchant/operate")
    public void operateMerchant(@RequestBody OperateUserRequest operateUserRequest){

    }

    //获取用户列表
    @ApiOperation("获取用户列表")
    @GetMapping("/user/list/{adminId}")
    public List<GoodListVO> list(@PathVariable("adminId") Integer adminId) {
        return null;
    }

    //用户搜索
    @ApiOperation("搜索用户")
    @PostMapping("/user/search")
    public Page<List<SearchAdminVO>> searchUser(@RequestBody SearchRequest searchRequest){
        return null;
    }

    //用户 注销、封号、解冻
    @ApiOperation("操作用户")
    @PutMapping("/user/operate")
    public void operateUser(@RequestBody OperateUserRequest operateUserRequest){

    }

}
