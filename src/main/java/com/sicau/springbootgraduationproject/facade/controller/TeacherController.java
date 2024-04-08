package com.sicau.springbootgraduationproject.facade.controller;


import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.Teacher;
import com.sicau.springbootgraduationproject.facade.service.TeacherService;
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
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/teacher")
@Api(tags = "教师管理模块")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/searchTeacher")
    @ApiOperation(tags = "协作共享模块", value = "邀请协助人", notes = "邀请协作的接口，点击邀请协作，就调用这个接口，不需要任何参数直接请求即可,返回的是教师所有信息，取teacherName即可")
    public Result<?> getTeacherList() {
        List<Teacher> teacherList = teacherService.getTeacherList();
        return new Result<>().success().put(teacherList);
    }
}
