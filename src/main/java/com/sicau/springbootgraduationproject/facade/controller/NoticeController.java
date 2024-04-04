package com.sicau.springbootgraduationproject.facade.controller;


import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.Notice;
import com.sicau.springbootgraduationproject.facade.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
@RestController
@RequestMapping("/api/notice")
@Api(tags = "系统公告")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @GetMapping("/publish")
    @ApiOperation("发布系统通知，无需参数")
    public Result<?> getSystemNotice(){
        Notice result =  noticeService.getNotice();
        return new Result<>().success().put(result);
    }
}
