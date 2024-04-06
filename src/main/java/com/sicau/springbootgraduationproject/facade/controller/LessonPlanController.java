package com.sicau.springbootgraduationproject.facade.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanService;
import com.sicau.springbootgraduationproject.facade.service.UserService;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlan;
import com.sicau.springbootgraduationproject.facade.vo.UserInfo;
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
        PageResult<LessonPlan> pageResult = null;
        try {
            Page<LessonPlan> page = lessonPlanService.getLessonPlanPage(queryLessonPlan);
            pageResult = new PageResult<>(queryLessonPlan.getCurrentPage(), queryLessonPlan.getPageSize(), page.getTotal(), page.getPages(), page.getRecords());
            pageResult.setCode(CommonCode.SUCCESS.getCode());
            pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pageResult;
    }

    @PostMapping("/lessonPlanUpdate")
    @ApiOperation("编辑教案")
    public Result<?> updateLessonPlan(@RequestBody LessonPlanInfo lessonPlanInfo) {
        boolean result = false;
        try {
            result = lessonPlanService.getUpdateLessonPlan(lessonPlanInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result ? new Result<>().success().put(result) : new Result<>().fail();
    }

    @PostMapping("/lessonPlanAdd")
    @ApiOperation("新增教案")
    public Result<?> addLessonPlan(@RequestBody LessonPlanInfo lessonPlanInfo) {
        boolean result = false;
        try {
            result = lessonPlanService.getAddLessonPlan(lessonPlanInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result ? new Result<>().success().put(result) : new Result<>().fail();
    }

    @GetMapping("/lessonPlanType")
    @ApiOperation(tags = "首页", value = "首页用户可视化查询，统计教案类型，不用参数")
    public Result<?> countLessonPlanType() {
        List<LessonPlan> result = null;
        try {
            result = lessonPlanService.getLessonPlanCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("reslut",result);
        return new Result<>().success().put(result);
    }

    @PostMapping("/cooperation")
    @ApiOperation(tags = "协作共享模块",value = "协作共享模块需要传输的参数必须要有nickname")
    public Result<?> getTeam(@RequestBody UserInfo userInfo) {
        List<LessonPlan> result = null;
        try {
            result = lessonPlanService.getTeam(userInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Result<>().success().put(result);
    }
}
