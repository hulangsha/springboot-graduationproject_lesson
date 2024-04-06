package com.sicau.springbootgraduationproject.facade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 记录用户账号创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 用户最后一次登录时间
     */
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    /**
     * 姓名
     */
    @TableField("nickname")
    private String nickname;

    /**
     * 是否删除，0删除，1不删除
     */
    @TableField("isDelete")
    private String isDelete;

    /**
     * 上次登录地点
     */
    @TableField("last_login_address")
    private String lastLoginAddress;

    /**
     * 用户头像
     */
    @TableField("head_portrait")
    private String headPortrait;


}
