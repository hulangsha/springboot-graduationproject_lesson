package com.sicau.springbootgraduationproject.facade.controller;


import com.alibaba.fastjson.JSONObject;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.CountUser;
import com.sicau.springbootgraduationproject.facade.service.CountUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
@RequestMapping("/api/countUser")
@Api(tags = "首页")
public class CountUserController {

    @Autowired
    private CountUserService countUserService;

    @GetMapping("/visual")
    @ApiOperation("可视化数据API，无需参数，直接访问接口即可拿到数据")
    public Result<?> getVisual() {
        List<CountUser> result = null;
        try {
            result = countUserService.getVisual();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject();
        ArrayList<Integer> downloadsList = new ArrayList<>();
        ArrayList<Integer> pageViewList = new ArrayList<>();
        ArrayList<Integer> theMonthList = new ArrayList<>();
        for (CountUser c: result) {
            downloadsList.add(c.getDownloads());
            pageViewList.add(c.getPageView());
            theMonthList.add(c.getTheMonth());
        }
        jsonObject.put("downloadsList",downloadsList);
        jsonObject.put("pageViewList",pageViewList);
        jsonObject.put("theMonthList",theMonthList);
        return new Result<>().success().put(jsonObject);
    }
}
