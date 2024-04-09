package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.Course;
import com.sicau.springbootgraduationproject.facade.entity.CourseSessions;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.QueryCourse;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-08
 */
public interface CourseSessionsService extends IService<CourseSessions> {

    List<CourseSessions> searchCourseSession();

}
