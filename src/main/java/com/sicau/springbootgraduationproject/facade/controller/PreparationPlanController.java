package com.sicau.springbootgraduationproject.facade.controller;


import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.facade.service.PreparationPlanService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api("备课计划和进度模块")
public class PreparationPlanController {

    @Autowired
    private PreparationPlanService preparationPlanService;

    @PostMapping("/preparationPlanPage")
    public PageResult getPreparationPlanPage(){
        return null;
    }
}
