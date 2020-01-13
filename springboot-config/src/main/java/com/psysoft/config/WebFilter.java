package com.psysoft.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.psysoft.pojo.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebFilter {

    @Autowired
    private Application myproperties;

    /**
     *  从配置文件中获取指定隔离url
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
//        System.out.println("-----------"+myproperties.getUrl().split(","));
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new UrlFilter());
//        bean.addUrlPatterns("/getUser","/hello");

        bean.addUrlPatterns(myproperties.getUrl().split(","));
        bean.addInitParameter("paramName", "paramValue");
        bean.setName("MyFilter");
        bean.setOrder(1);
        return bean;
    }


    private class UrlFilter implements javax.servlet.Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
           // url满足进入处理
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            System.out.println("过滤器请求的url :"+request.getRequestURI());
            // 获取系统时间
            Calendar ca = Calendar.getInstance();
            int hour = ca.get(Calendar.HOUR_OF_DAY);
            // 设置限制运行时间
            if (!(hour>=8&&hour<=22)) {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");
                // 消息
                Map<String, Object> messageMap = new HashMap<>();
                messageMap.put("status", "1");
                messageMap.put("message", "此接口可以请求时间为:8-22点");
                ObjectMapper objectMapper=new ObjectMapper();
                String writeValueAsString = objectMapper.writeValueAsString(messageMap);
                response.getWriter().write(writeValueAsString);
                return;
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }

        @Override
        public void destroy() {

        }
    }
}
