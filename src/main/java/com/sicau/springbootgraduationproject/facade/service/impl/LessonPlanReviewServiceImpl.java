package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlanReview;
import com.sicau.springbootgraduationproject.facade.vo.ResultLessonPlanReview;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

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
        //教案评审
        QueryWrapper<LessonPlanReview> lessonPlanReviewQueryWrapper = new QueryWrapper<>();
        List<LessonPlanReview> lessonPlanReviews = lessonPlanReviewMapper.selectList(lessonPlanReviewQueryWrapper);

        //评审人
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(userQueryWrapper);

        //教案
        QueryWrapper<LessonPlan> lessonPlanQueryWrapper = new QueryWrapper<>();
        List<LessonPlan> lessonPlans = lessonPlanMapper.selectList(lessonPlanQueryWrapper);

        Iterator<User> userIterator = users.iterator();
        HashMap<Integer, String> userMap = new HashMap<>();
        while (userIterator.hasNext()) {
            userMap.put(userIterator.next().getUserId(),userIterator.next().getNickname());
        }
        Iterator<LessonPlan> lessonPlanIterator = lessonPlans.iterator();
        HashMap<Integer, String> lessonMap = new HashMap<>();
        while (lessonPlanIterator.hasNext()) {
            lessonMap.put(lessonPlanIterator.next().getLessonPlanId(), lessonPlanIterator.next().getTitle());
        }
        for (LessonPlanReview l:lessonPlanReviews) {
            userMap.get(l.getReviewerId());
        }
        List<ResultLessonPlanReview> list = null;
        try {
            list = lessonPlanReviewMapper.queryLessonReviewMapperList();
        }catch (Exception e) {
            log.info("怎么了？：{}", e);
            throw new RuntimeException();
        }

        return list;
    }
}
