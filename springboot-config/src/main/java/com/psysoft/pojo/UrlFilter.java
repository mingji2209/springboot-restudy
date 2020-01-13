package com.psysoft.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application")
@PropertySource(value = "classpath:urlFilter")
public class UrlFilter {

    @Value("/index.html")
    private String loginUrl;  // 登录默认地址

    @Value("/index")
    private String noFilterUrl; // 不过滤

    @Value("/*")
    private String filterUrl; // 过滤url
}
