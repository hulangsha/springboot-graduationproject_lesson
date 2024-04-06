package com.sicau.springbootgraduationproject.facade.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("t_lesson_plan")
public class LessonPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 教案id
     */
    @TableId(value = "lesson_plan_id", type = IdType.AUTO)
    private Integer lessonPlanId;

    /**
     * 教案标题
     */
    @TableField("title")
    private String title;

    /**
     * 教学目标
     */
    @TableField("objectives")
    private String objectives;

    /**
     * 教学步骤
     */
    @TableField("steps")
    private String steps;

    /**
     * 教学资源
     */
    @TableField("resources")
    private String resources;

    /**
     * 创建者id
     */
    @TableField("creator_id")
    private Integer creatorId;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @TableField("last_update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdateTime;

    /**
     * 是否删除，0删除，1不删除
     */
    @TableField("isDelete")
    private String isDelete;

    /**
     * 是否共享，0共享，1不共享
     */
    @TableField("share_state")
    private String shareState;

    /**
     * 教案版本
     */
    @TableField("version")
    private Integer version;

    /**
     * 协作人
     */
    @TableField("team")
    private String team;


}
