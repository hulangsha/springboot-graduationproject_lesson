package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sicau.springbootgraduationproject.facade.entity.Notice;
import com.sicau.springbootgraduationproject.facade.mapper.NoticeMapper;
import com.sicau.springbootgraduationproject.facade.service.NoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements NoticeService {

    @Override
    public Notice getNotice() {
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        return this.getOne(wrapper);
    }
}
