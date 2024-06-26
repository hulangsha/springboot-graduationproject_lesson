package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlanReview;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.ClassroomFeedbackInfo;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanReviewInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlanReview;
import com.sicau.springbootgraduationproject.facade.vo.ResultLessonPlanReview;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface LessonPlanReviewService extends IService<LessonPlanReview> {

    List<ResultLessonPlanReview> getReviewPage();

    boolean getReviewUpdate(LessonPlanReviewInfo lessonPlanReviewInfo);

    boolean getReviewDelte(Integer id);

    boolean addSuggestPlan(LessonPlanReviewInfo lessonPlanReviewInfo);
}
