package com.psysoft.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
* Title: MyConfig
* Description:
* 自定义配置文件 
* Version:1.0.0
 */

@Component//使用@Configuration也可以
@ConfigurationProperties(prefix = "ipconfig")//前缀
@PropertySource(value = "classpath:ipconfig.properties")//配置文件路径  在resource目录下
public class IpConfig {

    private String ipWhiteList;

	/**  
	 * 获取ipWhiteList
	 * @return  ipWhiteList  
	 */
	public String getIpWhiteList() {
		return ipWhiteList;
	}


	public void setIpWhiteList(String ipWhiteList) {
		this.ipWhiteList = ipWhiteList;
	}  
  
    
}  
