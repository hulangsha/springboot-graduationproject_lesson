package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.sicau.springbootgraduationproject.facade.service.HistoricalLessonPlanService;
import com.sicau.springbootgraduationproject.facade.vo.QueryHistoricalLessonPlan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("/api/historicalLessonPlan")
@Api(tags = "历史教案管理模块")
public class HistoricalLessonPlanController {

    @Autowired
    private HistoricalLessonPlanService historicalLessonPlanService;

    @PostMapping("getHistoricalPlanPage")
    @ApiOperation(value = "查询历史教案，必须要用的参数是当前页和每页显示多少条")
    public Result<?> getHistoricalPlanPage(@RequestBody QueryHistoricalLessonPlan historicalLessonPlanInfo) {
        Page<HistoricalLessonPlan> pageResult = historicalLessonPlanService.getHistoricalPlanPage(historicalLessonPlanInfo);

return null;
    }
}
