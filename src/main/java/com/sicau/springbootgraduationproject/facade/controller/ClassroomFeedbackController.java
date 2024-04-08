package com.sicau.springbootgraduationproject.facade.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.ClassroomFeedback;
import com.sicau.springbootgraduationproject.facade.service.ClassroomFeedbackService;
import com.sicau.springbootgraduationproject.facade.vo.ClassroomFeedbackInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryClassroomFeedback;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-08
 */
@RestController
@RequestMapping("/api/classroomFeedback")
@Api(tags = "课堂反馈和评估")
public class ClassroomFeedbackController {

    @Autowired
    private ClassroomFeedbackService classroomFeedbackService;

    @PostMapping("/searchFeedbackPage")
    @ApiOperation(value = "查询课堂反馈和评估", notes = "课堂反馈和评估分页查询，必须要的两个参数currentPage, pageSize")
    public PageResult getFeedbackPage(@RequestBody QueryClassroomFeedback queryClassroomFeedback) {
        PageResult<ClassroomFeedback> pageResult = null;
        try {
            Page<ClassroomFeedback> page = classroomFeedbackService.searchFeedbackPage(queryClassroomFeedback);
            pageResult = new PageResult<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
            pageResult.setCode(CommonCode.SUCCESS.getCode());
            pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pageResult;

    }

    @PostMapping("/getAddFeedback")
    @ApiOperation(value = "添加课堂反馈评估", notes = "需要将反馈评估内容和分数传回来，其他的根据情况而定比如教案id和评估人id还有session_id节次id，这些都需要传")
    public Result<?> getAddFeedback(@RequestBody ClassroomFeedbackInfo classroomFeedbackInfo) {
        boolean result = classroomFeedbackService.addFeedback(classroomFeedbackInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

    @PostMapping("/getUpdateFeedback")
    @ApiOperation(value = "编辑课堂反馈评估", notes = "需要将反馈评估内容和分数传回来，其他的根据情况而定比如教案id和评估人id还有session_id节次id，这些根据情况而定，如果有人修改就传，也就是要给用户有修改的文本框")
    public Result<?> getUpdateFeedback(@RequestBody ClassroomFeedbackInfo classroomFeedbackInfo) {
        boolean result = classroomFeedbackService.updateFeedback(classroomFeedbackInfo);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }


}
