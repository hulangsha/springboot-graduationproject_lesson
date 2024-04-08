package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.QueryTeacher;
import com.sicau.springbootgraduationproject.facade.vo.TeacherInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface TeacherService extends IService<Teacher> {

    List<Teacher> getTeacherList();

    Page<Teacher> getSearchTeacher(QueryTeacher queryTeacher);

    boolean getAddTeacher(TeacherInfo teacherInfo);

    boolean getDeleteTeacher(Integer id);
}
