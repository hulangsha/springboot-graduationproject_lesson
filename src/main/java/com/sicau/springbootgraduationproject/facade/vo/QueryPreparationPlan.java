package com.sicau.springbootgraduationproject.facade.vo;

import lombok.Data;

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
public class QueryPreparationPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 计划id
     */
    private Integer planId;

    /**
     * 计划标题
     */
    private String title;

    /**
     * 教案id
     */
    private Integer lessonPlanId;

    /**
     * 教学目标
     */
    private String objectives;

    /**
     * 教学内容
     */
    private String content;

    /**
     * 教学资源
     */
    private String resources;

    /**
     * 创建者id
     */
    private Integer creatorId;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 是否删除，0删除，1不删除
     */
    private String isDelete;

    /**
     * 统计字段完成情况
     */
    private Integer fieldCount;

    /**
     * 当前页
     */
    private Long currentPage;

    /**
     * 每页显示条数
     */
    private Long pageSize;


}
