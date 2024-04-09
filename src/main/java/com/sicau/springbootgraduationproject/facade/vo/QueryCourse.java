package com.sicau.springbootgraduationproject.facade.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Data
public class QueryCourse implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 教师id
     */
    private Integer teacherId;

    /**
     * 是否删除，0删除，1不删除
     */
    private String isDelete;


    //当前页
    private Long currentPage;

    //每页显示多少条
    private Long pageSize;


}
