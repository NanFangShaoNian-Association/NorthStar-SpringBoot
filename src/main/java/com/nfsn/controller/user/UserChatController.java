package com.nfsn.controller.user;

import com.nfsn.constants.ResultCode;
import com.nfsn.exception.UserArticleException;
import com.nfsn.model.vo.UserListVO;
import com.nfsn.service.FriendService;
import com.nfsn.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    @Resource
    private UserService userService;

    @Resource
    private FriendService friendService;

    @GetMapping("/list/{userId}")
    @ApiImplicitParams(
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户令牌", dataType = "String", required = true)
    )
    @ApiOperation("获取好友列表")
    public List<UserListVO> list(@PathVariable("userId") String userId){
        Integer value = 0;
        try {
            value = Integer.valueOf(userId);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            throw new UserArticleException(ResultCode.PARAM_IS_INVALID);
        }

        return friendService.listFriend(value);
    }

//    //获取好友信息
//    @GetMapping("/getFriend/{userId}/{friendId}")
//    @ApiOperation("获取好友信息")
//    public String getFriend(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId){
//        return "list";
//    }

    /**
     * 搜索用户（手机号、用户名）
     *
     * @return
     */
    @GetMapping("/searchUser")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", name = "Authorization", value = "用户令牌", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "target", value = "查询字段，依据前缀查询，p为手机号，u为用户名，例：u-李四", dataType = "String", dataTypeClass = String.class, required = true)
    })
    @ApiOperation("搜索用户（手机号、用户名）")
    public List<UserListVO> searchUser(String target){
        return userService.searchUser(target);
    }

}
