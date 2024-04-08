package com.sicau.springbootgraduationproject.facade.mapper;

import com.sicau.springbootgraduationproject.facade.entity.LessonPlanReview;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sicau.springbootgraduationproject.facade.vo.ResultLessonPlanReview;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface LessonPlanReviewMapper extends BaseMapper<LessonPlanReview> {

    List<LessonPlanReview> queryLessonReviewMapperList();
}
