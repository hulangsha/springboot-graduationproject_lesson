package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlan;
import com.sicau.springbootgraduationproject.facade.vo.UserInfo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface LessonPlanService extends IService<LessonPlan> {

    /**
    * 教案分页查询
    * */
    Page<LessonPlan> getLessonPlanPage(QueryLessonPlan queryLessonPlan);

    /**
     * 编辑教案
     * */
    boolean getUpdateLessonPlan(LessonPlanInfo lessonPlanInfo);

    /**
     * 新增教案
     * */
    boolean getAddLessonPlan(LessonPlanInfo lessonPlanInfo);

    List<LessonPlan> getLessonPlanCount();

    List<LessonPlan> getTeam();

    List<LessonPlan> getShareLessonPlan();

    List<LessonPlan> getPersonalLessonPlan();

    boolean changeShareState(LessonPlanInfo lessonPlanInfo);

    boolean getLessonPlanDelete(Integer id);

    List<LessonPlan> searchLessonPlan();
}
