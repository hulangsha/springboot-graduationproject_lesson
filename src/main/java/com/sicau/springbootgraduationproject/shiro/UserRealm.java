package com.sicau.springbootgraduationproject.shiro;


import com.sicau.springbootgraduationproject.common.component.JwtComponent;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.service.UserService;
import com.sicau.springbootgraduationproject.facade.vo.UserInfo;
import com.sicau.springbootgraduationproject.facade.vo.UserRolePermission;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    private JwtComponent jwtComponent;
    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        if (Objects.isNull(user)) {
            throw new AuthorizationException();
        }
        Integer userId = user.getUserId();
        if (0 == userId || null == userId) {
            throw new AuthorizationException();
        }
        List<UserRolePermission> userRolePermissionList = userService.getUserRoleAndPermission(userId);
        if (CollectionUtils.isEmpty(userRolePermissionList)) {
            throw new AuthorizationException();
        }
        HashSet<String> roleSet = new HashSet<>();
        HashSet<String> permissionSet = new HashSet<>();
        for (UserRolePermission userRolePermission : userRolePermissionList) {
            roleSet.add(userRolePermission.getRoleName());
            permissionSet.add(userRolePermission.getPermissionUrl());
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(roleSet);
        info.addStringPermissions(permissionSet);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = authenticationToken.getPrincipal().toString();
        String userName = jwtComponent.getUserName(token);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        User user = userService.getUser(userInfo);

        if (Objects.isNull(user)){
            throw new AuthenticationException();
        }
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, token, this.getName());
            return info;

    }

    /**
     * 支持Token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }
}
