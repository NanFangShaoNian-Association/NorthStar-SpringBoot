package com.nfsn.controller.user;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserController
 * @Author: 团子tz
 * @CreateTime: 2022/10/30 20:40
 * @Description: 用户操作类
 */
@RestController
@RequestMapping("/users")
@Api("用户操作类")
public class UserController {

//    //获取好友信息
//    @GetMapping("/getFriend/{userId}/{friendId}")
//    @ApiOperation("获取购物车信息")
//    public String getFriend(@PathVariable("userId") String userId, @PathVariable("friendId") String friendId){
//        return "list";
//    }
}
