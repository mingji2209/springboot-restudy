package com.psysoft.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LogHandlerInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
       // log.info("preHandle请求URL：" + requestURL.toString());
        System.out.println("preHandle请求URL：" + requestURL.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       // log.info("postHandle返回modelAndView之前");
        System.out.println("postHandle返回modelAndView之前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       // log.info("afterCompletion执行完请求方法完全返回之后");
        System.out.println("afterCompletion执行完请求方法完全返回之后");
    }
}
