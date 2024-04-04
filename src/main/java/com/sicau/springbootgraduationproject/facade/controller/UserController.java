package com.sicau.springbootgraduationproject.facade.controller;


import com.alibaba.fastjson.JSONObject;
import com.sicau.springbootgraduationproject.common.component.JwtComponent;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.service.UserService;
import com.sicau.springbootgraduationproject.facade.vo.UserInfo;
import com.sicau.springbootgraduationproject.facade.vo.UserRolePermission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/user")
@Api(tags = "用户管理API", value = "Controller类")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtComponent jwtComponent;

    @PostMapping("/login")
    @ApiOperation("根据用户的用户名和密码进行登录")
    public Result<?> login(@RequestBody UserInfo userInfo) {
        User user = userService.getUser(userInfo);
        if (Objects.isNull(user)) {
            return new Result<>().fail();
        }
        String token = jwtComponent.sign(userInfo.getUserName(), userInfo.getPassword());
        List<UserRolePermission> userRoleAndPermission = userService.getUserRoleAndPermission(user.getUserId());
        Integer roleId = userRoleAndPermission.get(0).getRoleId();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", token);
        jsonObject.put("user", user);
        jsonObject.put("roleId", roleId);
        return new Result<>().success().put(jsonObject);
    }

}
