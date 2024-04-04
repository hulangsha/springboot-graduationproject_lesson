package com.sicau.springbootgraduationproject.facade.mapper;

import com.sicau.springbootgraduationproject.facade.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sicau.springbootgraduationproject.facade.vo.UserRolePermission;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface UserMapper extends BaseMapper<User> {

    List<UserRolePermission> getUserRoleAndPermissionList(Integer userId);
}
