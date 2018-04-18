package com.stars.project.web;

import com.stars.project.core.constant.SystemConst;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author : mxy
 * @Date : Created on 19:03 2018/4/15
 * @Description: 登录拦截器
 * @Version : 1.0
 * @Modified By :
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute(SystemConst.LOGINED) != null){
            return true;
        }else {
            request.getRequestDispatcher("/login").forward(request,response);
        }
        return false;
    }

}
