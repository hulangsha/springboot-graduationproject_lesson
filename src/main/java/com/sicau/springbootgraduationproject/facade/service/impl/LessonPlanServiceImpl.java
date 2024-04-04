package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.mapper.LessonPlanMapper;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
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
public class LessonPlanServiceImpl extends ServiceImpl<LessonPlanMapper, LessonPlan> implements LessonPlanService {

    @Override
    public Page<LessonPlan> getLessonPlanPage(QueryLessonPlan queryLessonPlan) {
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            throw new RuntimeException();

        }
        User user = (User) currentUser.getPrincipal();
        Integer userId = user.getUserId();
        Page<LessonPlan> page = new Page<>();
        page.setCurrent(queryLessonPlan.getCurrentPage());
        page.setSize(queryLessonPlan.getPageSize());
        QueryWrapper<LessonPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("creator_id",1);
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean getUpdateLessonPlan(LessonPlanInfo lessonPlanInfo) {
        LessonPlan lessonPlan = new LessonPlan();
        BeanUtils.copyProperties(lessonPlanInfo, lessonPlan);
        return this.updateById(lessonPlan);
    }

    @Override
    public boolean getAddLessonPlan(LessonPlanInfo lessonPlanInfo) {
        LessonPlan lessonPlan = new LessonPlan();
        BeanUtils.copyProperties(lessonPlanInfo, lessonPlan);
        return this.save(lessonPlan);
    }
}
