package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.HistoricalLessonPlan;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.mapper.HistoricalLessonPlanMapper;
import com.sicau.springbootgraduationproject.facade.service.HistoricalLessonPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.HistoricalLessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryHistoricalLessonPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@Service
public class HistoricalLessonPlanServiceImpl extends ServiceImpl<HistoricalLessonPlanMapper, HistoricalLessonPlan> implements HistoricalLessonPlanService {

    @Autowired
    private HistoricalLessonPlanMapper historicalLessonPlanMapper;

    @Override
    public Page<HistoricalLessonPlan> getHistoricalPlanPage(QueryHistoricalLessonPlan historicalLessonPlanInfo) {
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            throw new RuntimeException("没有查询到用户");
        }
        User user = (User) subject.getPrincipal();
        Page<HistoricalLessonPlan> page = new Page<>();
        page.setCurrent(historicalLessonPlanInfo.getCurrentPage());
        page.setSize(historicalLessonPlanInfo.getPageSize());
        QueryWrapper<HistoricalLessonPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("creator_id", user.getUserId());
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean getHistoricalPlanUpdate(HistoricalLessonPlanInfo historicalLessonPlanInfo) {
        HistoricalLessonPlan historicalLessonPlan = new HistoricalLessonPlan();
        BeanUtils.copyProperties(historicalLessonPlanInfo, historicalLessonPlan);
        return this.updateById(historicalLessonPlan);
    }

    @Override
    public boolean getHistoricalDelete(String id) {
        HistoricalLessonPlan historicalLessonPlan = historicalLessonPlanMapper.selectById(id);
        if (null == historicalLessonPlan) {
            return false;
        }
        historicalLessonPlan.setIsDelete("0");
        historicalLessonPlanMapper.updateById(historicalLessonPlan);
        return true;
    }

    @Override
    public Page<HistoricalLessonPlan> getHistoricalPlanPageManager(QueryHistoricalLessonPlan historicalLessonPlanInfo) {
        Page<HistoricalLessonPlan> page = new Page<>();
        page.setCurrent(historicalLessonPlanInfo.getCurrentPage());
        page.setSize(historicalLessonPlanInfo.getPageSize());
        QueryWrapper<HistoricalLessonPlan> queryWrapper = new QueryWrapper<>();
        return this.page(page, queryWrapper);
    }
}
