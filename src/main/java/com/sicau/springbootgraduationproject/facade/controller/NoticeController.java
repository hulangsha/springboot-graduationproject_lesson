package com.sicau.springbootgraduationproject.facade.controller;


import com.alibaba.fastjson.JSONObject;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.Notice;
import com.sicau.springbootgraduationproject.facade.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<Notice> result;
        try {
             result =  noticeService.getNotice();
        }catch (Exception e){
            e.printStackTrace();
            return new Result<>().success().put(e);
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("result",result);
        return new Result<>().success().put(jsonObject);
    }
}
