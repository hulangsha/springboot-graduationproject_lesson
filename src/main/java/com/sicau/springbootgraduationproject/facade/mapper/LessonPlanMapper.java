package com.sicau.springbootgraduationproject.facade.mapper;

import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface LessonPlanMapper extends BaseMapper<LessonPlan> {

    List<LessonPlan> getCountLessonPlan();

    boolean updateLessonPlan(@Param("historicalLessonPlan") HistoricalLessonPlan historicalLessonPlan);
}
