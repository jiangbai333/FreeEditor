/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.common;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

//测试拦截器1
public class handlerInterceptor implements HandlerInterceptor{
    
    @Autowired
    private HttpSession session;
    
    //在进入handler方法之前执行，用于身份认证、身份授权等权限管理
    //比如身份认证，如果认证没有通过，则需要此方法拦截，不再向下执行
    /**
     * 
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception 
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        response.addHeader("Access-Control-Allow-Origin","*");
        /*String url = request.getRequestURI();
        return url.contains("display");*/
        System.out.println(session.getAttribute("user"));
        //返回false表示拦截，不向下执行
        return true;
    }

    //在进入handler方法之后同时在返回modelAndView之前
    //应用场景从modelAndView出发，将一些公用的模型数据在这里传递到视图中（比如菜单的导航）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println();
    }
    //在执行handler方法之后执行
    //应用场景：可以使用统一的异常处理，还可以用于统一的日志处理
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("第一个拦截器----执行后");
    }
}
