package com.psysoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
// ServletComponentScan //Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码
@ServletComponentScan
public class App
{
    public static void main( String[] args ) {
        SpringApplication.run(App.class,args);
        System.out.println();

    System.out.println( "程序已启动..." );
    }
}
