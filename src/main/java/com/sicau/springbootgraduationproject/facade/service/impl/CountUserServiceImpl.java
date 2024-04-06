package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sicau.springbootgraduationproject.facade.entity.CountUser;
import com.sicau.springbootgraduationproject.facade.mapper.CountUserMapper;
import com.sicau.springbootgraduationproject.facade.service.CountUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
@Service
public class CountUserServiceImpl extends ServiceImpl<CountUserMapper, CountUser> implements CountUserService {

    @Override
    public List<CountUser> getVisual() {
        QueryWrapper<CountUser> queryWrapper = new QueryWrapper<>();
        return this.list(queryWrapper);
    }
}
