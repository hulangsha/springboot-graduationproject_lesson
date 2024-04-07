package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.sicau.springbootgraduationproject.facade.mapper.HistoricalLessonPlanMapper;
import com.sicau.springbootgraduationproject.facade.service.HistoricalLessonPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.QueryHistoricalLessonPlan;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Service
public class HistoricalLessonPlanServiceImpl extends ServiceImpl<HistoricalLessonPlanMapper, HistoricalLessonPlan> implements HistoricalLessonPlanService {

    @Override
    public Page<HistoricalLessonPlan> getHistoricalPlanPage(QueryHistoricalLessonPlan historicalLessonPlanInfo) {
        Page<HistoricalLessonPlan> page = new Page<>();
        page.setCurrent(historicalLessonPlanInfo.getCurrentPage());
        return null;
    }
}
