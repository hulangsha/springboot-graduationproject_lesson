package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sicau.springbootgraduationproject.facade.entity.Teacher;
import com.sicau.springbootgraduationproject.facade.mapper.TeacherMapper;
import com.sicau.springbootgraduationproject.facade.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Override
    public List<Teacher> getTeacherList() {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        return this.list(queryWrapper);
    }
}
