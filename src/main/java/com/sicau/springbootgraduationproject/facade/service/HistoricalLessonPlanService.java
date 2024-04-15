package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.HistoricalLessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryHistoricalLessonPlan;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface HistoricalLessonPlanService extends IService<HistoricalLessonPlan> {

    Page<HistoricalLessonPlan> getHistoricalPlanPage(QueryHistoricalLessonPlan historicalLessonPlanInfo);

    boolean getHistoricalPlanUpdate(HistoricalLessonPlanInfo historicalLessonPlanInfo);

    boolean getHistoricalDelete(String id);

    Page<HistoricalLessonPlan> getHistoricalPlanPageManager(QueryHistoricalLessonPlan historicalLessonPlanInfo);

    List<Integer> getHistoricalPlanVersion(Integer lessonId);
}
