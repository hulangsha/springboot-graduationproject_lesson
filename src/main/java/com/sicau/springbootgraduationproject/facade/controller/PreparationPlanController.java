package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.facade.entity.PreparationPlan;
import com.sicau.springbootgraduationproject.facade.service.PreparationPlanService;
import com.sicau.springbootgraduationproject.facade.vo.QueryPreparationPlan;
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
@RequestMapping("/api/preparationPlan")
@Api(tags = "备课计划和进度模块")
public class PreparationPlanController {

    @Autowired
    private PreparationPlanService preparationPlanService;

    @PostMapping("/preparationPlanPage")
    @ApiOperation("查询准备计划和进度，必须传的参数是currentPage和pageSize")
    public PageResult getPreparationPlanPage(@RequestBody QueryPreparationPlan queryPreparationPlan){
        PageResult<PreparationPlan> pageResult = null;
        try {
            Page<PreparationPlan> page = preparationPlanService.getPreparationPlanPage(queryPreparationPlan);
            pageResult = new PageResult<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        pageResult.setCode(CommonCode.SUCCESS.getCode());
        pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        return pageResult;
    }
}
