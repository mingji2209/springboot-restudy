package com.psysoft.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *   对应application的操作类
 */
@Component
@ConfigurationProperties(prefix = "com.psy")
@Data
@NoArgsConstructor
public class Application {

    @Value("/hello") //默认值
    private String url;

}
