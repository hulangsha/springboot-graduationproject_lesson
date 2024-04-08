package com.sicau.springbootgraduationproject.facade.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlanReview;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanReviewService;
import com.sicau.springbootgraduationproject.facade.vo.ClassroomFeedbackInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlanReview;
import com.sicau.springbootgraduationproject.facade.vo.ResultLessonPlanReview;
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
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/lessonPlanReview")
@Api(tags = "教案评审和反馈模块")
public class LessonPlanReviewController {

    @Autowired
    private LessonPlanReviewService lessonPlanReviewService;

    @PostMapping("/reviewPage")
    @ApiOperation(value = "教案评审和反馈", notes = "教案评审和反馈不用参数，这个用分页，要是你可以分页也行。")
    public Result<?> getReviewPage() {
        List<ResultLessonPlanReview> result = lessonPlanReviewService.getReviewPage();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("list", result);
        return new Result<>().success().put(jsonObject);
    }

    @PostMapping("/updateReview")
    @ApiOperation(value = "教案评审", notes = "教案评审就相当于是编辑功能，需要将所有修改的内容传进来")
    public Result<?> getReviewUpdate(@RequestBody ClassroomFeedbackInfo classroomFeedbackInfo) {
        boolean result = lessonPlanReviewService.getReviewUpdate(classroomFeedbackInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

    @GetMapping("/deleteReview")
    @ApiOperation(value = "教案评审删除", notes = "删除教案评审，只需要将id传过来即可")
    public Result<?> getReviewDelete(@RequestParam("feedback_id") Integer id) {
        boolean result = lessonPlanReviewService.getReviewDelte(id);
        if (result) {
            return new Result<>().success().put(result);
        }

        return new Result<>().fail();
    }
}
