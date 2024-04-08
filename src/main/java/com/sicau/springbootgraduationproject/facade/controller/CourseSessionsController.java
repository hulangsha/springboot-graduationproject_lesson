package com.sicau.springbootgraduationproject.facade.controller;


import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.CourseSessions;
import com.sicau.springbootgraduationproject.facade.service.CourseSessionsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-08
 */
@RestController
@RequestMapping("/api/courseSessions")
@Api(tags = "课程安排-节次")
public class CourseSessionsController {

    @Autowired
    private CourseSessionsService courseSessionsService;

    @GetMapping("searchCourseSession")
    @ApiOperation(value = "查询节次", notes = "查询节次不需要传输参数,我把所有的数据都返回给你，你把节次展示给用户选择就行了，session_num")
    public Result<?> searchCourseSession() {
        List<CourseSessions> courseSessionsList = courseSessionsService.searchCourseSession();
        if (courseSessionsList.isEmpty()) {
            return new Result<>().fail();
        }
        return new Result<>().success().put(courseSessionsList);
    }
}
