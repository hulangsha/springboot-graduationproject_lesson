package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlanReview;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.mapper.LessonPlanMapper;
import com.sicau.springbootgraduationproject.facade.mapper.LessonPlanReviewMapper;
import com.sicau.springbootgraduationproject.facade.mapper.UserMapper;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanReviewService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanService;
import com.sicau.springbootgraduationproject.facade.service.UserService;
import com.sicau.springbootgraduationproject.facade.vo.ClassroomFeedbackInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlanReview;
import com.sicau.springbootgraduationproject.facade.vo.ResultLessonPlanReview;
import com.sicau.springbootgraduationproject.facade.vo.ReviewVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Service
@Slf4j
public class LessonPlanReviewServiceImpl extends ServiceImpl<LessonPlanReviewMapper, LessonPlanReview> implements LessonPlanReviewService {

    @Autowired
    private LessonPlanReviewMapper lessonPlanReviewMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LessonPlanMapper lessonPlanMapper;


    @Override
    public List<ResultLessonPlanReview> getReviewPage() {
        QueryWrapper<LessonPlanReview> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("isDelete", CommonCode.CONST_NUMBER_ONE.getCode());
        List<LessonPlanReview> reviews = lessonPlanReviewMapper.selectList(queryWrapper);

        List<ReviewVo> collect = reviews.stream().map(review -> {
            LessonPlan lessonPlan = lessonPlanMapper.selectById(review.getLessonPlanId());
            User user = userMapper.selectById(review.getReviewerId());
            ReviewVo reviewVo = new ReviewVo();
            reviewVo.setLessonPlanReview(review);
            reviewVo.setLessonPlan(lessonPlan);
            reviewVo.setUser(user);
            return reviewVo;
        }).collect(Collectors.toList());

        ArrayList<ResultLessonPlanReview> lessonPlanReviewArrayList = new ArrayList<>();
        Iterator<ReviewVo> iterator = collect.iterator();

        while (iterator.hasNext()) {
            ReviewVo reviewVo = iterator.next();
            LessonPlan lessonPlan = reviewVo.getLessonPlan();
            LessonPlanReview lessonPlanReview = reviewVo.getLessonPlanReview();
            User user = reviewVo.getUser();
            ResultLessonPlanReview planReview = new ResultLessonPlanReview();
            planReview.setReviewId(lessonPlanReview.getReviewId());
            planReview.setComments(lessonPlanReview.getComments());
            planReview.setReviewTime(lessonPlanReview.getReviewTime());
            planReview.setIsDelete(lessonPlanReview.getIsDelete());
            planReview.setTitle(lessonPlan.getTitle());
            planReview.setNickname(user.getNickname());
            System.out.println(planReview);
            lessonPlanReviewArrayList.add(planReview);
        }
        return lessonPlanReviewArrayList;
    }

    @Override
    public boolean getReviewUpdate(ClassroomFeedbackInfo classroomFeedbackInfo) {
        LessonPlanReview lessonPlanReview = new LessonPlanReview();
        BeanUtils.copyProperties(classroomFeedbackInfo, lessonPlanReview);
        return this.updateById(lessonPlanReview);
    }

    @Override
    public boolean getReviewDelte(Integer id) {
        return this.removeById(id);
    }
}
