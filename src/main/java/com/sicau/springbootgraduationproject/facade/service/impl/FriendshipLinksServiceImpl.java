package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sicau.springbootgraduationproject.facade.entity.FriendshipLinks;
import com.sicau.springbootgraduationproject.facade.mapper.FriendshipLinksMapper;
import com.sicau.springbootgraduationproject.facade.service.FriendshipLinksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 友情链接表 服务实现类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
@Service
public class FriendshipLinksServiceImpl extends ServiceImpl<FriendshipLinksMapper, FriendshipLinks> implements FriendshipLinksService {

    @Override
    public FriendshipLinks getFriendShipLink() {
        QueryWrapper<FriendshipLinks> queryWrapper = new QueryWrapper<>();
        return this.getOne(queryWrapper);
    }
}
