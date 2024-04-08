package com.sicau.springbootgraduationproject.facade.vo;

import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlanReview;
import com.sicau.springbootgraduationproject.facade.entity.User;
import lombok.Data;

@Data
public class ReviewVo {
    private LessonPlan lessonPlan;
    private LessonPlanReview lessonPlanReview;
    private User user;
}
