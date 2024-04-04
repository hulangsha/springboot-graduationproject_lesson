package com.sicau.springbootgraduationproject.facade.mapper;

import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
