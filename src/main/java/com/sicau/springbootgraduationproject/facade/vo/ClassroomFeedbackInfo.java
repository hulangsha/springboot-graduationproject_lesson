package com.sicau.springbootgraduationproject.facade.vo;

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
public class ClassroomFeedbackInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 反馈id
     */
    private Integer feedbackId;

    /**
     * 教案id
     */
    private Integer lessonPlanId;

    /**
     * 反馈和评估人id
     */
    private Integer evaluatorId;

    /**
     * 反馈内容
     */
    private String feedbackContent;

    /**
     * 评分
     */
    private String score;

    /**
     * 反馈时间
     */
    private LocalDateTime feedbackTime;

    /**
     * 是否删除，0删除，1不删除
     */
    private String isDelete;

    /**
     * 关联课程节次表的节次id
     */
    private Integer sessionId;


}
