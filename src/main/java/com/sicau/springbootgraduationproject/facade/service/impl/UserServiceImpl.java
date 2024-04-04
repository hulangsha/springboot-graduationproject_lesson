package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.mapper.UserMapper;
import com.sicau.springbootgraduationproject.facade.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.UserInfo;
import com.sicau.springbootgraduationproject.facade.vo.UserRolePermission;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(UserInfo userInfo) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userInfo.getUserName()).eq("password", userInfo.getPassword());

        return this.getOne(wrapper);
    }

    @Override
    public List<UserRolePermission> getUserRoleAndPermission(Integer userId) {
        return userMapper.getUserRoleAndPermissionList(userId);
    }


}
