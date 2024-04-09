package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.Teacher;
import com.sicau.springbootgraduationproject.facade.service.TeacherService;
import com.sicau.springbootgraduationproject.facade.vo.QueryTeacher;
import com.sicau.springbootgraduationproject.facade.vo.TeacherInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/getTeacherList")
    @ApiOperation(tags = "教师管理模块", value = "查询教师信息", notes = "查询教师，需要分页")
    public PageResult searchTeacher(@RequestBody QueryTeacher queryTeacher) {
        Page<Teacher> page = teacherService.getSearchTeacher(queryTeacher);
        PageResult<Teacher> pageResult = new PageResult<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
        pageResult.setCode(CommonCode.SUCCESS.getCode());
        pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        return pageResult;

    }

    @PostMapping("/getAddTeacher")
    @ApiOperation(tags = "教师管理模块", value = "添加教师", notes = "添加教师")
    public Result<?> searchTeacher(@RequestBody TeacherInfo teacherInfo) {
        boolean result = teacherService.getAddTeacher(teacherInfo);
        if (result) {
            return new Result<>().success().put(result);
        }

        return new Result<>().fail();
    }

    @GetMapping("/getDeleteTeacher")
    @ApiOperation(tags = "教师管理模块", value = "删除教师", notes = "删除教师,需要传入教师的id")
    public Result<?> deleteTeacher(@RequestParam("teacherId") Integer id) {
        boolean result = teacherService.getDeleteTeacher(id);
        if (result) {
            return new Result<>().success().put(result);
        }

        return new Result<>().fail();
    }




}
