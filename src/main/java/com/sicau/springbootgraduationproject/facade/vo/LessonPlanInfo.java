package com.sicau.springbootgraduationproject.facade.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
public class LessonPlanInfo implements Serializable {

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
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 最后修改时间
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", timezone = "GMT+8")
    private LocalDateTime lastUpdateTime;

    /**
     * 是否删除，0删除，1不删除
     */
    private String isDelete;

    /**
     * 是否共享，0共享，1不共享
     */
    private String shareState;

    /**
     * 教案版本
     */
    private Integer version;

    /**
     * 协作人
     */
    @TableField("team")
    private String team;




}
