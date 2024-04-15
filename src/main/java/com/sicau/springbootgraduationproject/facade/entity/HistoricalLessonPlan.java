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
@TableName("t_historical_lesson_plan")
public class HistoricalLessonPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 历史教案id
     */
    @TableId(value = "historical_lesson_plan_id", type = IdType.AUTO)
    private Integer historicalLessonPlanId;

    /**
     * 教案id
     */
    @TableField("lesson_plan_id")
    private Integer lessonPlanId;

    /**
     * 版本号
     */
    @TableField("version")
    private Integer version;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建者id
     */
    @TableField("creator_id")
    private Integer creatorId;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 修改者id
     */
    @TableField("updater_id")
    private Integer updaterId;

    /**
     * 是否删除，0删除，1不删除
     */
    @TableField("isDelete")
    private String isDelete;

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


}
