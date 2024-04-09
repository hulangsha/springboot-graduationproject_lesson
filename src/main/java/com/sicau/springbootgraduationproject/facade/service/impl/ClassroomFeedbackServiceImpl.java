package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.facade.entity.ClassroomFeedback;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.mapper.ClassroomFeedbackMapper;
import com.sicau.springbootgraduationproject.facade.service.ClassroomFeedbackService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.ClassroomFeedbackInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryClassroomFeedback;
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
 * @since 2024-04-08
 */
@Service
public class ClassroomFeedbackServiceImpl extends ServiceImpl<ClassroomFeedbackMapper, ClassroomFeedback> implements ClassroomFeedbackService {

    @Override
    public Page<ClassroomFeedback> searchFeedbackPage(QueryClassroomFeedback queryClassroomFeedback) {
        QueryWrapper<ClassroomFeedback> queryWrapper = null;
        Page<ClassroomFeedback> page = null;
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            throw new RuntimeException("拿不到数据，用户不存在");
        }
        //获取所登录用户
        User user = (User) subject.getPrincipal();
        Integer userId = user.getUserId();
        //判断评估反馈是否属于本人所授课程
        try {
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("isDelete", CommonCode.CONST_NUMBER_ONE.getCode()).eq("evaluator_id", userId);
            page = new Page<>();
            page.setCurrent(queryClassroomFeedback.getCurrentPage());
            page.setSize(queryClassroomFeedback.getPageSize());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return this.page(page, queryWrapper);
    }

    @Override
    public boolean addFeedback(ClassroomFeedbackInfo classroomFeedbackInfo) {
        ClassroomFeedback classroomFeedback = new ClassroomFeedback();
        BeanUtils.copyProperties(classroomFeedbackInfo, classroomFeedback);
        return this.save(classroomFeedback);
    }

    @Override
    public boolean updateFeedback(ClassroomFeedbackInfo classroomFeedbackInfo) {
        ClassroomFeedback classroomFeedback = new ClassroomFeedback();
        BeanUtils.copyProperties(classroomFeedbackInfo, classroomFeedback);
        return this.updateById(classroomFeedback);
    }
}
