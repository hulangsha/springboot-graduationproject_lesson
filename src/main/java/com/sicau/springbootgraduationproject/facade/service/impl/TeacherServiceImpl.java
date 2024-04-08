package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.Teacher;
import com.sicau.springbootgraduationproject.facade.mapper.TeacherMapper;
import com.sicau.springbootgraduationproject.facade.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.QueryTeacher;
import com.sicau.springbootgraduationproject.facade.vo.TeacherInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public List<Teacher> getTeacherList() {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        return this.list(queryWrapper);
    }

    @Override
    public Page<Teacher> getSearchTeacher(QueryTeacher queryTeacher) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<>();
        Page<Teacher> page = new Page<>();
        page.setSize(queryTeacher.getPageSize());
        page.setCurrent(queryTeacher.getCurrentPage());
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean getAddTeacher(TeacherInfo teacherInfo) {
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacherInfo, teacher);
        return this.save(teacher);
    }

    @Override
    public boolean getDeleteTeacher(Integer id) {
        Teacher teacher = teacherMapper.selectById(id);

        if (null == teacher) {
            return false;
        }
        teacher.setIsDelete("0");
        teacherMapper.updateById(teacher);
        return true;
    }
}
