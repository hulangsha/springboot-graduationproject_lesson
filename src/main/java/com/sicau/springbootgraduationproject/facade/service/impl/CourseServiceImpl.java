package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.facade.entity.Course;
import com.sicau.springbootgraduationproject.facade.mapper.CourseMapper;
import com.sicau.springbootgraduationproject.facade.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.CourseInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryCourse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Page<Course> searchCourse(QueryCourse queryCourse) {
        Page<Course> page = new Page<>();
        QueryWrapper<Course> queryWrapper = new QueryWrapper<>();
        page.setCurrent(queryCourse.getCurrentPage());
        page.setSize(queryCourse.getPageSize());
        queryWrapper.eq("isDelete", CommonCode.CONST_NUMBER_ONE.getCode());
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean addCourse(CourseInfo courseInfo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseInfo, course);
        return this.save(course);
    }

    @Override
    public boolean updateCourse(CourseInfo courseInfo) {
        Course course = new Course();
        BeanUtils.copyProperties(courseInfo, course);
        return this.updateById(course);
    }

    @Override
    public boolean deleteCourse(Integer id) {
        Course course = courseMapper.selectById(id);
        if (null == course) {
            return false;
        }
        course.setIsDelete("0");
        courseMapper.updateById(course);
        return true;
    }
}
