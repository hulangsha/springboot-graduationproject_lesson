package com.sicau.springbootgraduationproject.facade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_course")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    @TableId(value = "course_id", type = IdType.AUTO)
    private Integer courseId;

    /**
     * 课程名称
     */
    @TableField("course_name")
    private String courseName;

    /**
     * 教师id
     */
    @TableField("teacher_id")
    private Integer teacherId;

    /**
     * 是否删除，0删除，1不删除
     */
    @TableField("isDelete")
    private String isDelete;

    /**
     * 教师姓名
     */
    @TableField("teacher_name")
    private String teacherName;

    /**
     * 课程节次
     */
    @TableField("course_sessions")
    private String courseSessions;




}
