package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.PreparationPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.PreparationPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryPreparationPlan;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface PreparationPlanService extends IService<PreparationPlan> {

    Page<PreparationPlan> getPreparationPlanPage(QueryPreparationPlan queryPreparationPlan);

    boolean addPreparationPlan(PreparationPlanInfo preparationPlanInfo);

    boolean deletePreparationPlan(Integer id);
}
