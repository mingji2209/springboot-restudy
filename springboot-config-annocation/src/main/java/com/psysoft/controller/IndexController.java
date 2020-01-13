package com.psysoft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
public class IndexController {

    @RequestMapping("/hello")
    public String  index(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "hello,world!"+ sdf.format(Calendar.getInstance().getTime());
    }
}
