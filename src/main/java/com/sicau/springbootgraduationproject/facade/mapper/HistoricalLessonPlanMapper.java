package com.sicau.springbootgraduationproject.facade.mapper;

import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanInfo;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface HistoricalLessonPlanMapper extends BaseMapper<HistoricalLessonPlan> {

    boolean addLessonPlan(LessonPlanInfo oldLessonPlan);
}
