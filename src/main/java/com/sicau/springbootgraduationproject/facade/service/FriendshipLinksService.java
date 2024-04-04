package com.sicau.springbootgraduationproject.facade.service;

import com.sicau.springbootgraduationproject.facade.entity.FriendshipLinks;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 友情链接表 服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-04
 */
public interface FriendshipLinksService extends IService<FriendshipLinks> {

    FriendshipLinks getFriendShipLink();
}
