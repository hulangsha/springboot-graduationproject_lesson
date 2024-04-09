package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.sicau.springbootgraduationproject.facade.service.HistoricalLessonPlanService;
import com.sicau.springbootgraduationproject.facade.vo.HistoricalLessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryHistoricalLessonPlan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getHistoricalPlanPage")
    @ApiOperation(value = "教案分页查询", notes = "查询历史教案，必须要用的参数是当前页和每页显示多少条,currentPage,pageSize")
    public PageResult getHistoricalPlanPage(@RequestBody QueryHistoricalLessonPlan historicalLessonPlanInfo) {
        Page<HistoricalLessonPlan> pageResult = historicalLessonPlanService.getHistoricalPlanPage(historicalLessonPlanInfo);
        PageResult<HistoricalLessonPlan> result = new PageResult<>(pageResult.getCurrent(), pageResult.getSize(), pageResult.getTotal(), pageResult.getPages(), pageResult.getRecords());
        result.setCode(CommonCode.SUCCESS.getCode());
        result.setMsg(CommonCode.SUCCESS.getMessage());
        return result;
    }

    @PostMapping("/updateHistoricalPlan")
    @ApiOperation(value = "编辑教案", notes = "编辑教案传递基本参数即可，其他的就用原来的数据")
    public Result<?> getHistoricalUpdate(@RequestBody HistoricalLessonPlanInfo historicalLessonPlanInfo) {
        boolean result = historicalLessonPlanService.getHistoricalPlanUpdate(historicalLessonPlanInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

    @GetMapping("/deleteHistoricalPlan")
    @ApiOperation(value = "删除教案", notes = "删除教案，传一个历史教案id即可")
    public Result<?> getHistoricalDelete(@RequestParam("historicalLessonPlanId") String id) {
        boolean result = historicalLessonPlanService.getHistoricalDelete(id);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

    @PostMapping("/getHistoricalPlanPage")
    @ApiOperation(value = "管理员历史教案分页查询", notes = "查询管理员历史教案，必须要用的参数是当前页和每页显示多少条,currentPage,pageSize，必须是管理员用户才能访问")
    @RequiresRoles("管理员")
    public PageResult getHistoricalPlanPageManager(@RequestBody QueryHistoricalLessonPlan historicalLessonPlanInfo) {
        Page<HistoricalLessonPlan> pageResult = historicalLessonPlanService.getHistoricalPlanPageManager(historicalLessonPlanInfo);
        PageResult<HistoricalLessonPlan> result = new PageResult<>(pageResult.getCurrent(), pageResult.getSize(), pageResult.getTotal(), pageResult.getPages(), pageResult.getRecords());
        result.setCode(CommonCode.SUCCESS.getCode());
        result.setMsg(CommonCode.SUCCESS.getMessage());
        return result;
    }
}
