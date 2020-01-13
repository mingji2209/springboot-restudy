package com.psysoft.config;

import com.psysoft.config.annocation.WebListen;
import com.psysoft.config.annocation.WebMyFilter;
import com.psysoft.config.annocation.WebMyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class WebCoreConfig {



    public ServletRegistrationBean myServlet(){
        return  new ServletRegistrationBean(new WebMyServlet());
    }


    public ServletListenerRegistrationBean myListenner(){
        return new ServletListenerRegistrationBean(new WebListen());
    }


    public FilterRegistrationBean myFilter(){
        return new FilterRegistrationBean(new WebMyFilter());
    }
}
