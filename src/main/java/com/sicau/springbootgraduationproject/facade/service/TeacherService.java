package com.sicau.springbootgraduationproject.facade.service;

import com.sicau.springbootgraduationproject.facade.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
