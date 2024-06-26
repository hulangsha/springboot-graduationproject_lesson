package com.sicau.springbootgraduationproject.facade.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.mapper.HistoricalLessonPlanMapper;
import com.sicau.springbootgraduationproject.facade.mapper.LessonPlanMapper;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlan;
import com.sicau.springbootgraduationproject.facade.vo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Service
public class LessonPlanServiceImpl extends ServiceImpl<LessonPlanMapper, LessonPlan> implements LessonPlanService {

    @Autowired
    private LessonPlanMapper lessonPlanMapper;

    @Autowired
    private HistoricalLessonPlanMapper historicalLessonPlanMapper;
    @Override
    public Page<LessonPlan> getLessonPlanPage(QueryLessonPlan queryLessonPlan) {
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            throw new RuntimeException("没有获取到用户");
        }
        User user = (User) currentUser.getPrincipal();
        Integer userId = user.getUserId();
        Page<LessonPlan> page = new Page<>();
        page.setCurrent(queryLessonPlan.getCurrentPage());
        page.setSize(queryLessonPlan.getPageSize());
        QueryWrapper<LessonPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("creator_id",userId).eq("isDelete", CommonCode.CONST_NUMBER_ONE.getCode());
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean getUpdateLessonPlan(LessonPlanInfo lessonPlanInfo) {
        //保存版本信息，以及更新版本
        Integer oldVersion = lessonPlanInfo.getVersion();
        Integer newVersion = oldVersion + CommonCode.CONST_NUMBER_ONE.getCode();
        //拿到更新之前的数据
        Integer lessonPlanId = lessonPlanInfo.getLessonPlanId();
        QueryWrapper<LessonPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("lesson_plan_id", lessonPlanId);
        LessonPlan oldLessonPlan = lessonPlanMapper.selectOne(queryWrapper);
        //拿到更新之前的信息并存储
        LessonPlanInfo oldLessonPlanInfo = new LessonPlanInfo();
        oldLessonPlanInfo.setLessonPlanId(oldLessonPlan.getLessonPlanId());
        oldLessonPlanInfo.setVersion(oldLessonPlan.getVersion());
        oldLessonPlanInfo.setCreatorId(oldLessonPlan.getCreatorId());
        oldLessonPlanInfo.setIsDelete(oldLessonPlan.getIsDelete());
        oldLessonPlanInfo.setTitle(oldLessonPlan.getTitle());
        oldLessonPlanInfo.setObjectives(oldLessonPlan.getObjectives());
        oldLessonPlanInfo.setSteps(oldLessonPlan.getSteps());
        oldLessonPlanInfo.setResources(oldLessonPlan.getResources());
        //修改教案之前先向历史教案表插入数据
        boolean historicalResult = historicalLessonPlanMapper.addLessonPlan(oldLessonPlanInfo);
        LessonPlan lessonPlan = new LessonPlan();
        //迭代版本
        lessonPlanInfo.setVersion(newVersion);
        if (historicalResult) {
            BeanUtils.copyProperties(lessonPlanInfo, lessonPlan);
        }
        return this.updateById(lessonPlan);
    }

    @Override
    public boolean getAddLessonPlan(LessonPlanInfo lessonPlanInfo) {
        LessonPlan lessonPlan = new LessonPlan();
        BeanUtils.copyProperties(lessonPlanInfo, lessonPlan);
        return this.save(lessonPlan);
    }

    @Override
    public List<LessonPlan> getLessonPlanCount() {
        List<LessonPlan> result = lessonPlanMapper.getCountLessonPlan();
        return result;
    }

    @Override
    public List<LessonPlan> getTeam() {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            throw new RuntimeException("没有查询到用户");
        }
        User user = (User) subject.getPrincipal();
        QueryWrapper<LessonPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("team", user.getNickname());
        return this.list(queryWrapper);
    }


    @Override
    public List<LessonPlan> getShareLessonPlan() {
        QueryWrapper<LessonPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("share_state", CommonCode.CONST_NUMBER_ZERO.getCode());
        return this.list(queryWrapper);
    }

    @Override
    public List<LessonPlan> getPersonalLessonPlan() {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            throw new RuntimeException("没有获取到用户的信息");
        }
        User user = (User) subject.getPrincipal();
        QueryWrapper<LessonPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("creator_id", user.getUserId());
        return this.list(queryWrapper);
    }

    @Override
    public boolean changeShareState(LessonPlanInfo lessonPlanInfo) {
        LessonPlan lessonPlan = new LessonPlan();
        BeanUtils.copyProperties(lessonPlanInfo, lessonPlan);
        return this.updateById(lessonPlan);
    }

    @Override
    public boolean getLessonPlanDelete(Integer id) {
        LessonPlan lessonPlan = lessonPlanMapper.selectById(id);

        if (null == lessonPlan) {
            return false;
        }
        lessonPlan.setIsDelete("0");
        lessonPlanMapper.updateById(lessonPlan);
        return true;
    }

    @Override
    public List<LessonPlan> searchLessonPlan() {
        QueryWrapper<LessonPlan> queryWrapper = new QueryWrapper<>();
        return this.list(queryWrapper);
    }

    @Override
    public JSONObject compareLessonContent(Integer lessonPlanId, Integer version) {
        //拿到修改之前的教案
        Integer oldVersion = version - CommonCode.CONST_NUMBER_ONE.getCode();
        QueryWrapper<HistoricalLessonPlan> historicalLessonPlanQueryWrapper = new QueryWrapper<>();
        historicalLessonPlanQueryWrapper.eq("lesson_plan_id", lessonPlanId).eq("version", oldVersion);
        HistoricalLessonPlan historicalLessonPlan = historicalLessonPlanMapper.selectOne(historicalLessonPlanQueryWrapper);
        //拿到修改之后的教案
        QueryWrapper<LessonPlan> lessonPlanQueryWrapper = new QueryWrapper<>();
        lessonPlanQueryWrapper.eq("lesson_plan_id", lessonPlanId).eq("version", version);
        LessonPlan lessonPlan = lessonPlanMapper.selectOne(lessonPlanQueryWrapper);
        JSONObject result = new JSONObject();
        result.put("historicalLessonPlan", historicalLessonPlan);
        result.put("lessonPlan", lessonPlan);
        return result;
    }

    @Override
    public boolean getRecoverLesson(Integer lessonId, Integer version) {
        QueryWrapper<HistoricalLessonPlan> historicalLessonPlanQueryWrapper = new QueryWrapper<>();
        historicalLessonPlanQueryWrapper.eq("lesson_plan_id", lessonId).eq("version", version);
        HistoricalLessonPlan historicalLessonPlan = historicalLessonPlanMapper.selectOne(historicalLessonPlanQueryWrapper);
        LessonPlan lessonPlan = lessonPlanMapper.selectById(lessonId);
        Integer formerVersion = lessonPlan.getVersion();
        historicalLessonPlan.setVersion(formerVersion);
        boolean result = lessonPlanMapper.updateLessonPlan(historicalLessonPlan);

        return result;
    }
}
