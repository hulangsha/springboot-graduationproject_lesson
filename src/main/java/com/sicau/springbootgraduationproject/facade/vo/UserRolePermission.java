package com.sicau.springbootgraduationproject.facade.vo;

import lombok.Data;

@Data
public class UserRolePermission {
    private Integer userId;
    private Integer roleId;
    private Integer permissionId;
    private String userName;
    private String roleName;
    private String permissionUrl;
}
