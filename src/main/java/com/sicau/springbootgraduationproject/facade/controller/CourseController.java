package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.Course;
import com.sicau.springbootgraduationproject.facade.service.CourseService;
import com.sicau.springbootgraduationproject.facade.service.CourseSessionsService;
import com.sicau.springbootgraduationproject.facade.vo.CourseInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryCourse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/course")
@Api(tags = "课程管理模块")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/searchCoursePage")
    @ApiOperation(value = "课程管理查询", notes = "必须要的参数当前页和每页显示多少条")
    public PageResult searchCoursePage(@RequestBody QueryCourse queryCourse) {
        Page<Course> page = courseService.searchCourse(queryCourse);
        PageResult<Course> pageResult = new PageResult<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
        pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        pageResult.setCode(CommonCode.SUCCESS.getCode());
        return pageResult;
    }


    @PostMapping("/addCourse")
    @ApiOperation(value = "课程增加", notes = "基本的参数都需要,必须要管理员才能对此接口进行操作，不然返回404")
    @RequiresRoles("管理员")
    public Result<?> addCourse(@RequestBody CourseInfo courseInfo) {
        boolean result = courseService.addCourse(courseInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

    @PostMapping("/updateCourse")
    @ApiOperation(value = "课程编辑", notes = "基本的参数都需要,必须要管理员才能对此接口进行操作，课程id是必须的")
    @RequiresRoles("管理员")
    public Result<?> updateCourse(@RequestBody CourseInfo courseInfo) {
        boolean result = courseService.updateCourse(courseInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }


    @GetMapping("/deleteCourse")
    @ApiOperation(value = "课程删除", notes = "只需要课程id,必须要管理员才能对此接口进行操作，否则返回404")
    @RequiresRoles("管理员")
    public Result<?> updateCourse(@RequestParam("courseId") Integer id) {
        boolean result = courseService.deleteCourse(id);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }


}
