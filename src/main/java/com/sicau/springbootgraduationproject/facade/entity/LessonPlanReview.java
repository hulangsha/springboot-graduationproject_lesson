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
@TableName("t_lesson_plan_review")
public class LessonPlanReview implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评审id
     */
    @TableId(value = "review_id", type = IdType.AUTO)
    private Integer reviewId;

    /**
     * 教案id
     */
    @TableField("lesson_plan_id")
    private Integer lessonPlanId;

    /**
     * 评审人id
     */
    @TableField("reviewer_id")
    private Integer reviewerId;

    /**
     * 评审人意见
     */
    @TableField("comments")
    private String comments;

    /**
     * 评审时间
     */
    @TableField("review_time")
    private LocalDateTime reviewTime;

    /**
     * 是否删除，0删除，1不删除
     */
    @TableField("isDelete")
    private String isDelete;


}
