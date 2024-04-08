package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

        QueryWrapper<ClassroomFeedback> queryWrapper = new QueryWrapper<>();
        Page<ClassroomFeedback> page = new Page<>();
        page.setCurrent(queryClassroomFeedback.getCurrentPage());
        page.setSize(queryClassroomFeedback.getPageSize());


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
