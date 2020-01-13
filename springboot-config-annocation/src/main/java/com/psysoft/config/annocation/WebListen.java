package com.psysoft.config.annocation;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class WebListen implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听服务器开启");
        log.info("监听服务器开启");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听服务器关闭");
    }
}
