package com.sicau.springbootgraduationproject.facade.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.facade.entity.MultimediaFile;
import com.sicau.springbootgraduationproject.facade.mapper.MultimediaFileMapper;
import com.sicau.springbootgraduationproject.facade.service.MultimediaFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sicau.springbootgraduationproject.facade.vo.MultimediaFileInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryMultimediaFile;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MultimediaFileServiceImpl extends ServiceImpl<MultimediaFileMapper, MultimediaFile> implements MultimediaFileService {

    @Autowired
    private MultimediaFileMapper multimediaFileMapper;
    @Override
    public Page<MultimediaFile> getMultimediaPage(QueryMultimediaFile queryMultimediaFile) {
        Page<MultimediaFile> page = new Page<>();
        QueryWrapper<MultimediaFile> queryWrapper = new QueryWrapper<>();
        page.setSize(queryMultimediaFile.getPageSize());
        page.setCurrent(queryMultimediaFile.getCurrentPage());
        queryWrapper.eq("isDelete", CommonCode.CONST_NUMBER_ONE.getCode());
        return this.page(page, queryWrapper);
    }

    @Override
    public boolean addMultimedia(MultimediaFileInfo multimediaFileInfo) {
        MultimediaFile multimediaFile = new MultimediaFile();
        BeanUtils.copyProperties(multimediaFileInfo, multimediaFile);
        return this.save(multimediaFile);
    }

    @Override
    public boolean updateMultimedia(MultimediaFileInfo multimediaFileInfo) {
        MultimediaFile multimediaFile = new MultimediaFile();
        BeanUtils.copyProperties(multimediaFileInfo, multimediaFile);
        return this.updateById(multimediaFile);
    }

    @Override
    public boolean deleteMultimedia(Integer id) {
        MultimediaFile multimediaFile = multimediaFileMapper.selectById(id);
        if (null == multimediaFile) {
            return false;
        }
        multimediaFile.setIsDelete("0");

        return true;
    }
}
