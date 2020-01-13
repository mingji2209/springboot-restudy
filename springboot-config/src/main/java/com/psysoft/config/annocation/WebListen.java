package com.psysoft.config.annocation;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class WebListen implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听服务器开启");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听服务器关闭");
    }
}
