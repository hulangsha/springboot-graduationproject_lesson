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
public class QueryLessonPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 教案id
     */
    private Integer lessonPlanId;

    /**
     * 教案标题
     */
    private String title;

    /**
     * 教学目标
     */
    private String objectives;

    /**
     * 教学步骤
     */
    private String steps;

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

    //当前页
    private Long currentPage;

    //每页显示多少条
    private Long pageSize;


}
