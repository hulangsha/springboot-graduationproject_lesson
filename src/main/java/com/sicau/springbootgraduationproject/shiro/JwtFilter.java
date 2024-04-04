package com.sicau.springbootgraduationproject.shiro;

import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends BasicHttpAuthenticationFilter {
    /**
     * 判断请求是否带有Authorization的token（isAttemptLogin)
     * 如果存在，登录认证（executeLogin)
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if(isLoginAttempt(request,response)){
            try {
                executeLogin(request,response);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }

        }
        //允许匿名访问
        return true;
    }

    /**
     * 如果验证不通过（isAccessAllowed返回false，或者抛出异常），则执行该方法
     * 调用异常接口，向前端返回异常信息
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        response401(request,response);
        return false;
    }

    private void response401(ServletRequest request,ServletResponse response){
        HttpServletResponse res = (HttpServletResponse)response;
        try {
            res.sendRedirect("/api/employee/401");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取前端请求，验证请求头信息中是否有Authorization的token
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest)request;
        String token = req.getHeader("Authorization");
        if(StringUtils.isEmpty(token)){
            return false;

        }else {
            return true;
        }
    }

    /**
     * 登录认证
     * 通过subject.login（）
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        String token = req.getHeader("Authorization");
        JWTToken jwtToken = new JWTToken(token);
        getSubject(request,response).login(jwtToken);
        return super.executeLogin(request, response);
    }

    /**
     * 允许shiro请求跨域
     * 放行options请求
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        //解决跨域问题
        res.setHeader("Access-control-Allow-Origin",req.getHeader("Origin"));
        res.setHeader("Access-Control-Allow-Methods","GET,POST,PUT,DELETE");
        res.setHeader("Access-Control-Allow-Headers",req.getHeader("Access-Control-Request-Headers"));
        //跨域时首先发送一个option，这里给option返回正常状态
        if (req.getMethod().equals(RequestMethod.OPTIONS.name())){
            res.setStatus(HttpStatus.OK.value());
            return true;
        }
        return super.preHandle(request, response);
    }
}
