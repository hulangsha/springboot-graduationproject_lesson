package com.sicau.springbootgraduationproject.common.component;

import com.sicau.springbootgraduationproject.common.result.Result;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BaseControllerAdvice {
    @ExceptionHandler(value = UnauthorizedException.class)
    public Result<?> unAuthorize(UnauthorizedException e){
        return new Result<>().fail(CommonCode.UNAUTHORIZED.getCode(), CommonCode.UNAUTHORIZED.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> exceptionResponse(Exception e){
        return new Result<>().fail(CommonCode.Fail_SERVER.getCode(), CommonCode.Fail_SERVER.getMessage());
    }
}
