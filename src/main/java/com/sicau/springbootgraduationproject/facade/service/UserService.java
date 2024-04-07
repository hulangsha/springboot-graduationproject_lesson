package com.sicau.springbootgraduationproject.facade.service;

import com.sicau.springbootgraduationproject.facade.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.UserInfo;
import com.sicau.springbootgraduationproject.facade.vo.UserRolePermission;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface UserService extends IService<User> {

    User getUser(UserInfo userInfo);

    List<UserRolePermission> getUserRoleAndPermission(Integer userId);

    User getUserByUserName(UserInfo userInfo);
}
