package com.nfsn.controller.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nfsn.model.dto.SearchRequest;
import com.nfsn.model.vo.SearchUserVO;
import com.nfsn.model.vo.UserListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: UserChatController
 * @Author: 团子tz
 * @CreateTime: 2022/11/01 21:16
 * @Description: 用户聊天操作类
 */
@RestController
@RequestMapping("/users/chats")
@Api("用户聊天操作类")
public class UserChatController {

    @GetMapping("/list/{userId}")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户令牌", dataType = "String", required = true)
    )
    @ApiOperation("获取好友列表")
    public List<UserListVO> list(@PathVariable("userId") String userId){
        return null;
    }

//    //获取好友信息
//    @GetMapping("/getFriend/{userId}/{friendId}")
//    @ApiOperation("获取好友信息")
//    public String getFriend(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId){
//        return "list";
//    }

    //搜索（根据手机号/用户名）
    @ApiOperation("搜索（根据手机号/用户名）")
    @PostMapping("/merchant/search")
    public Page<List<SearchUserVO>> searchMerchant(@RequestBody SearchRequest searchRequest){
        return null;
    }
}
