package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanService;
import com.sicau.springbootgraduationproject.facade.service.UserService;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/lessonPlan")
@Api(tags = "教案模块")
public class LessonPlanController {

    @Autowired
    private LessonPlanService lessonPlanService;

    @Autowired
    private UserService userService;


    @PostMapping("/lessonPlanPage")
    @ApiOperation(value = "查询教案，并且分页,")
    public PageResult getLessonPlan(@RequestBody QueryLessonPlan queryLessonPlan) {
        Page<LessonPlan> page = lessonPlanService.getLessonPlanPage(queryLessonPlan);
        PageResult<LessonPlan> pageResult = new PageResult<>(queryLessonPlan.getCurrentPage(), queryLessonPlan.getPageSize(), page.getTotal(), page.getPages(), page.getRecords());
        pageResult.setCode(CommonCode.SUCCESS.getCode());
        pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        return pageResult;
    }

    @PostMapping("/lessonPlanUpdate")
    @ApiOperation("编辑教案")
    public Result<?> updateLessonPlan(@RequestBody LessonPlanInfo lessonPlanInfo) {
        boolean result = lessonPlanService.getUpdateLessonPlan(lessonPlanInfo);
        return result ? new Result<>().success().put(result) : new Result<>().fail();
    }

    @PostMapping("/lessonPlanAdd")
    @ApiOperation("新增教案")
    public Result<?> addLessonPlan(@RequestBody LessonPlanInfo lessonPlanInfo) {
        boolean result = lessonPlanService.getAddLessonPlan(lessonPlanInfo);
        return result ? new Result<>().success().put(result) : new Result<>().fail();
    }
}
