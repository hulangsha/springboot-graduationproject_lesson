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
@TableName("t_preparation_plan")
public class PreparationPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 计划id
     */
    @TableId(value = "plan_id", type = IdType.AUTO)
    private Integer planId;

    /**
     * 计划标题
     */
    @TableField("title")
    private String title;

    /**
     * 教案id
     */
    @TableField("lesson_plan_id")
    private Integer lessonPlanId;

    /**
     * 教学目标
     */
    @TableField("objectives")
    private String objectives;

    /**
     * 教学内容
     */
    @TableField("content")
    private String content;

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
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    @TableField("last_update_time")
    private LocalDateTime lastUpdateTime;

    /**
     * 是否删除，0删除，1不删除
     */
    @TableField("isDelete")
    private String isDelete;

    /**
     * 统计字段完成情况
     */
    @TableField("field_count")
    private Integer fieldCount;


}
