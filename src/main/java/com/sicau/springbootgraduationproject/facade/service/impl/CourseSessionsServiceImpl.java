package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.facade.entity.Course;
import com.sicau.springbootgraduationproject.facade.entity.CourseSessions;
import com.sicau.springbootgraduationproject.facade.mapper.CourseSessionsMapper;
import com.sicau.springbootgraduationproject.facade.service.CourseSessionsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.QueryCourse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-08
 */
@Service
public class CourseSessionsServiceImpl extends ServiceImpl<CourseSessionsMapper, CourseSessions> implements CourseSessionsService {

    @Override
    public List<CourseSessions> searchCourseSession() {
        QueryWrapper<CourseSessions> queryWrapper = new QueryWrapper<>();
        return this.list(queryWrapper);
    }



}
