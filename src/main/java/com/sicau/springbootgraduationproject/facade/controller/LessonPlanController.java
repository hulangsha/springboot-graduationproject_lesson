package com.sicau.springbootgraduationproject.facade.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sicau.springbootgraduationproject.common.component.CommonCode;
import com.sicau.springbootgraduationproject.common.result.PageResult;
import com.sicau.springbootgraduationproject.common.result.Result;
import com.sicau.springbootgraduationproject.facade.entity.LessonPlan;
import com.sicau.springbootgraduationproject.facade.service.HistoricalLessonPlanService;
import com.sicau.springbootgraduationproject.facade.service.LessonPlanService;
import com.sicau.springbootgraduationproject.facade.service.UserService;
import com.sicau.springbootgraduationproject.facade.vo.LessonPlanInfo;
import com.sicau.springbootgraduationproject.facade.vo.QueryLessonPlan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Hu Langsha：2024/3/28
 * @since 2024-03-30
 */
@RestController
@RequestMapping("/api/lessonPlan")
@Api(tags = "教案模块")
@Slf4j
public class LessonPlanController {

    @Autowired
    private LessonPlanService lessonPlanService;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoricalLessonPlanService historicalLessonPlanService;


    @PostMapping("/lessonPlanPage")
    @ApiOperation(value = "查询教案，并且分页,")
    public PageResult getLessonPlan(@RequestBody QueryLessonPlan queryLessonPlan) {
        PageResult<LessonPlan> pageResult = null;
        try {
            Page<LessonPlan> page = lessonPlanService.getLessonPlanPage(queryLessonPlan);
            pageResult = new PageResult<>(page.getCurrent(), page.getSize(), page.getTotal(), page.getPages(), page.getRecords());
            pageResult.setCode(CommonCode.SUCCESS.getCode());
            pageResult.setMsg(CommonCode.SUCCESS.getMessage());
        } catch (Exception e) {
            log.info(String.valueOf(e));
        }
        return pageResult;
    }

    @PostMapping("/lessonPlanUpdate")
    @ApiOperation("编辑教案")
    public Result<?> updateLessonPlan(@RequestBody LessonPlanInfo lessonPlanInfo) {
        boolean result = false;
        try {
            result = lessonPlanService.getUpdateLessonPlan(lessonPlanInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result ? new Result<>().success().put(result) : new Result<>().fail();
    }

    @PostMapping("/lessonPlanAdd")
    @ApiOperation("新增教案")
    public Result<?> addLessonPlan(@RequestBody LessonPlanInfo lessonPlanInfo) {
        boolean result = false;
        try {
            result = lessonPlanService.getAddLessonPlan(lessonPlanInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result ? new Result<>().success().put(result) : new Result<>().fail();
    }

    @GetMapping("/lessonPlanType")
    @ApiOperation(tags = "首页", value = "统计教案类型", notes = "首页用户可视化查询，统计教案类型，不用参数")
    public Result<?> countLessonPlanType() {
        List<LessonPlan> result = null;
        try {
            result = lessonPlanService.getLessonPlanCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new Result<>().success().put(result);
    }

    @PostMapping("/cooperation")
    @ApiOperation(tags = "协作共享模块", value = "协作共享查询", notes = "协作共享模块,不需要参数")
    public Result<?> getTeam() {
        List<LessonPlan> lessonPlanList = lessonPlanService.getTeam();
        JSONObject result = new JSONObject();
        if (lessonPlanList.isEmpty()) {
            return new Result<>().fail().put(result);
        }
        result.put("list", lessonPlanList);
        return new Result<>().success().put(result);
    }

    @PostMapping("/shareLessonPlan")
    @ApiOperation(tags = "查看分享教案模块", value = "共享教案功能", notes = "查看和分享教案模块页面的共享功能，当点击查看分享教案菜单的时候就会发送请求，查询共享教案信息")
    /**
    * @description 查看和分享教案模块的共享教案的功能
    * @date        2024/4/813:17
    * @author      huls
    * @param       
    * @return      
    */
    public Result<?> getShareLessonPlan() {
        List<LessonPlan> shareLessonPlanList = lessonPlanService.getShareLessonPlan();
        JSONObject result = new JSONObject();
        if (shareLessonPlanList.isEmpty()) {
            return new Result<>().fail();
        }
        result.put("list", shareLessonPlanList);
        return new Result<>().success().put(result);
    }

    @PostMapping("/personalLessonPlan")
    @ApiOperation(tags = "查看分享教案模块", value = "私有化教案功能", notes = "查看和分享教案模块页面的私有化教案功能，当点击查看分享教案菜单的时候就会发送请求，查询私有教案信息")
    public Result<?> getPersonalLessonPlan() {
        List<LessonPlan> personalLessonPlan = lessonPlanService.getPersonalLessonPlan();
        JSONObject result = new JSONObject();
        if (personalLessonPlan.isEmpty()) {
            return new Result<>().fail().put(result);
        }
        result.put("list", personalLessonPlan);
        return new Result<>().success().put(result);
    }

    @PostMapping("/shareButton")
    @ApiOperation(tags = "查看分享教案模块", value = "共享按钮功能", notes = "查看和分享教案模块页面的共享按钮功能，目标是改变教案的共享属性，必须参数是共享状态share_state和教案的lesson_plan_id，不能传入其他参数，就只准传这两个")
    /**
    * @description 改变教案状态
    * @date        2024/4/813:44
    * @author      huls
    * @param       lessonPlanInfo
    * @return      Result<?>
    */
    public Result<?> getShareButton(@RequestBody LessonPlanInfo lessonPlanInfo) {
        boolean result = lessonPlanService.changeShareState(lessonPlanInfo);
        JSONObject resultJSON = new JSONObject();
        if (!result) {
            return new Result<>().fail().put(resultJSON);
        }
        return new Result<>().success().put(result);
    }

    @GetMapping("/deleteLessonPlan")
    @ApiOperation(value = "删除教案", notes = "只需要传入教案的id即可")
    public Result<?> getLessonPlanDelete(@RequestParam("lessonPlanId") Integer id) {
        boolean result = lessonPlanService.getLessonPlanDelete(id);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

    @GetMapping("searchLessonPlan")
    @ApiOperation(value = "课堂评估所用的查询教案", notes = "查询教案不需要传输参数,我把所有的数据都返回给你，你把教案名称展示给用户选择就行了，title，选择了教案的时候传输回后端的参数是教案的id，不是教案名字")
    public Result<?> searchLessonPlan () {
        List<LessonPlan> lessonPlanList = lessonPlanService.searchLessonPlan();
        if (lessonPlanList.isEmpty()) {
            return new Result<>().fail();
        }
        return new Result<>().success().put(lessonPlanList);
    }

    @GetMapping("/compareLesson")
    @ApiOperation(value = "比较教案", notes = "传入当前教案的id和版本号")
    public Result<?> getCompareLesson(@RequestParam Integer lessonPlanId,@RequestParam Integer version) {
        JSONObject result = lessonPlanService.compareLessonContent(lessonPlanId, version);
        if (result.isEmpty()) {
            return new Result<>().fail();
        }
        return new Result<>().success().put(result);
    }

    @GetMapping("/lessonVersion")
    @ApiOperation(value = "获取版本号", notes = "传入当前教案的id")
    public Result<?> getHistoricalLesson(@RequestParam Integer lessonId) {
        List<Integer> versionList = historicalLessonPlanService.getHistoricalPlanVersion(lessonId);
        if (versionList.isEmpty()) {
            return new Result<>().fail();
        }
        return new Result<>().success().put(versionList);
    }

    @GetMapping("/recoverLesson")
    @ApiOperation(value = "恢复教案", notes = "传入当前教案的id，以及要恢复的版本的版本号")
    public Result<?> getRecoverLesson(@RequestParam Integer lessonId, @RequestParam Integer version) {
        boolean result = lessonPlanService.getRecoverLesson(lessonId, version);
        if (result) {
            return new Result<>().success().put(result);
        }
        return new Result<>().fail();
    }

}
