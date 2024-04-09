package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.MultimediaFile;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.MultimediaFileInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryMultimediaFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
public interface MultimediaFileService extends IService<MultimediaFile> {

    Page<MultimediaFile> getMultimediaPage(QueryMultimediaFile queryMultimediaFile);

    boolean addMultimedia(MultimediaFileInfo multimediaFileInfo);

    boolean updateMultimedia(MultimediaFileInfo multimediaFileInfo);

    boolean deleteMultimedia(Integer id);
}
