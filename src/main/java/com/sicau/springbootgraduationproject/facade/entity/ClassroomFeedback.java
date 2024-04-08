package com.sicau.springbootgraduationproject.facade.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-08
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
     * 反馈和评估人id
     */
    @TableField("evaluator_id")
    private Integer evaluatorId;

    /**
     * 反馈内容
     */
    @TableField("feedback_content")
    private String feedbackContent;

    /**
     * 评分
     */
    @TableField("score")
    private String score;

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

    /**
     * 关联课程节次表的节次id
     */
    @TableField("session_id")
    private Integer sessionId;


}
