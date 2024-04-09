package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.CourseInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryCourse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface CourseService extends IService<Course> {

    Page<Course> searchCourse(QueryCourse queryCourse);

    boolean addCourse(CourseInfo courseInfo);

    boolean updateCourse(CourseInfo courseInfo);

    boolean deleteCourse(Integer id);
}
