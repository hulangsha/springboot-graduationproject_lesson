package com.sicau.springbootgraduationproject.facade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
@TableName("t_classroom_feedback")
public class ClassroomFeedback implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 反馈id
     */
    @TableId(value = "feedback_id", type = IdType.AUTO)
    private Integer feedbackId;

    /**
     * 教案id
     */
    @TableField("lesson_plan_id")
    private Integer lessonPlanId;

    /**
     * 学生id
     */
    @TableField("student_id")
    private Integer studentId;

    /**
     * 反馈内容
     */
    @TableField("feedback_content")
    private String feedbackContent;

    /**
     * 评分
     */
    @TableField("rating")
    private String rating;

    /**
     * 反馈时间
     */
    @TableField("feedback_time")
    private LocalDateTime feedbackTime;

    /**
     * 是否删除，0删除，1不删除
     */
    @TableField("isDelete")
    private String isDelete;


}
