package com.sicau.springbootgraduationproject.facade.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.facade.entity.ClassroomFeedback;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sicau.springbootgraduationproject.facade.vo.ClassroomFeedbackInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryClassroomFeedback;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-04-08
 */
public interface ClassroomFeedbackService extends IService<ClassroomFeedback> {

    Page<ClassroomFeedback> searchFeedbackPage(QueryClassroomFeedback queryClassroomFeedback);

    boolean addFeedback(ClassroomFeedbackInfo classroomFeedbackInfo);

    boolean updateFeedback(ClassroomFeedbackInfo classroomFeedbackInfo);
}
