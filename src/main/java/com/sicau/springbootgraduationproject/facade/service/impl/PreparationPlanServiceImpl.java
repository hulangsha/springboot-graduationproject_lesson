package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.facade.entity.PreparationPlan;
import com.sicau.springbootgraduationproject.facade.entity.User;
import com.sicau.springbootgraduationproject.facade.mapper.PreparationPlanMapper;
import com.sicau.springbootgraduationproject.facade.service.PreparationPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.PreparationPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryPreparationPlan;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
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
public class PreparationPlanServiceImpl extends ServiceImpl<PreparationPlanMapper, PreparationPlan> implements PreparationPlanService {

    @Override
    public Page<PreparationPlan> getPreparationPlanPage(QueryPreparationPlan queryPreparationPlan) {
        Page<PreparationPlan> page = new Page<>();
        page.setSize(queryPreparationPlan.getPageSize());
        page.setCurrent(queryPreparationPlan.getCurrentPage());
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            throw new RuntimeException();
        }
        User user = (User) subject.getPrincipal();
        QueryWrapper<PreparationPlan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("creator_id",user.getUserId()).eq("isDelete", CommonCode.CONST_NUMBER_ONE.getCode());
        return this.page(page,queryWrapper);
    }

    @Override
    public boolean addPreparationPlan(PreparationPlanInfo preparationPlanInfo) {
        PreparationPlan preparationPlan = new PreparationPlan();
        BeanUtils.copyProperties(preparationPlanInfo, preparationPlan);
        return this.save(preparationPlan);
    }

    @Override
    public boolean deletePreparationPlan(Integer id) {
        return this.removeById(id);
    }

    @Override
    public boolean updatePreparation(PreparationPlanInfo preparationPlanInfo) {
        PreparationPlan preparationPlan = new PreparationPlan();
        BeanUtils.copyProperties(preparationPlanInfo, preparationPlan);
        return this.updateById(preparationPlan);
    }
}
