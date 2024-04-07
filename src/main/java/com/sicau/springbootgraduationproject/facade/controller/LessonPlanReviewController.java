package com.sicau.springbootgraduationproject.facade.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlanReview;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanReviewService;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlanReview;
import com.sicau.springbootgraduationproject.facade.vo.ResultLessonPlanReview;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/lessonPlanReview")
@Api(tags = "教案评审和反馈模块")
public class LessonPlanReviewController {

    @Autowired
    private LessonPlanReviewService lessonPlanReviewService;

    @PostMapping("/reviewPage")
    @ApiOperation(value = "教案评审和反馈，必须传的数据是currentPage和pageSize，暂时不可用，先不做")
    public Result<?> getReviewPage() {
        List<ResultLessonPlanReview> result = lessonPlanReviewService.getReviewPage();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", result);
        jsonObject.put("code", CommonCode.SUCCESS.getCode());
        jsonObject.put("msg", CommonCode.SUCCESS.getMessage());
        return new Result<>().success().put(jsonObject);
    }
}
