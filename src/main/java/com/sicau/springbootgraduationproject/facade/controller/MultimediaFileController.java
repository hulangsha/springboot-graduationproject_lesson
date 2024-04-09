package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.MultimediaFile;
import com.sicau.springbootgraduationproject.facade.service.MultimediaFileService;
import com.sicau.springbootgraduationproject.facade.vo.MultimediaFileInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryMultimediaFile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/multimediaFile")
@Api(tags = "多媒体文件，此模块不用做")
public class MultimediaFileController {

    @Autowired
    private MultimediaFileService multimediaFileService;

    /**
    * 分页查询
    * */
    @PostMapping("/searchMultimediaPage")
    @ApiOperation(value = "查询多媒体文件", notes = "需要pageSize和currentPage")
    public PageResult getMultimediaPage(@RequestBody QueryMultimediaFile queryMultimediaFile) {
        Page<MultimediaFile> page = multimediaFileService.getMultimediaPage(queryMultimediaFile);
        PageResult<MultimediaFile> pageResult = new PageResult<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
        pageResult.setCode(CommonCode.SUCCESS.getCode());
        pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        return pageResult;
    }

    /**
    * 增加
    * */
    @PostMapping("/addMultimedia")
    @ApiOperation(value = "增加多媒体文件", notes = "需要管理员身份")
    public Result<?> addMultimedia(@RequestBody MultimediaFileInfo multimediaFileInfo) {
        boolean result = multimediaFileService.addMultimedia(multimediaFileInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }
    /**
     * 编辑
     * */
    @PostMapping("/updateMultimedia")
    @ApiOperation(value = "编辑多媒体文件", notes = "需要管理员身份，必须传fileId")
    public Result<?> updateMultimedia(@RequestBody MultimediaFileInfo multimediaFileInfo) {
        boolean result = multimediaFileService.updateMultimedia(multimediaFileInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

    /**
    * 删除
    * */

    @GetMapping("/deleteMultimedia")
    @ApiOperation(value = "删除多媒体文件", notes = "需要管理员身份，传个fileId就行了")
    public Result<?> updateMultimedia(@RequestParam("fileId") Integer id) {
        boolean result = multimediaFileService.deleteMultimedia(id);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }





}
