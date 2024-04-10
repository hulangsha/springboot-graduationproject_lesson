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
 * @since 2024-03-30
 */
@Data
public class LessonPlanReviewInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评审id
     */
    private Integer reviewId;

    /**
     * 教案id
     */
    private Integer lessonPlanId;

    /**
     * 评审人id
     */
    private Integer reviewerId;

    /**
     * 评审人意见
     */
    private String comments;

    /**
     * 评审时间
     */
    private LocalDateTime reviewTime;

    /**
     * 是否删除，0删除，1不删除
     */
    private String isDelete;


}
