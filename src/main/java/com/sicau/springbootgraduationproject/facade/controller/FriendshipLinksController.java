package com.sicau.springbootgraduationproject.facade.controller;


import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.FriendshipLinks;
import com.sicau.springbootgraduationproject.facade.service.FriendshipLinksService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 友情链接表 前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
@RestController
@RequestMapping("/api/friendshipLinks")
@Api(tags = "首页")
public class FriendshipLinksController {
    @Autowired
    private FriendshipLinksService friendshipLinksService;

    @GetMapping("/link")
    @ApiOperation("友情链接模块，不需要参数")
    public Result<?> getFriendShipLink() {
        FriendshipLinks result = friendshipLinksService.getFriendShipLink();
        return new Result<>().success().put(result);
    }
}
