package com.sicau.springbootgraduationproject.facade.service;

import com.sicau.springbootgraduationproject.facade.entity.CountUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
public interface CountUserService extends IService<CountUser> {

    List<CountUser> getVisual();
}
