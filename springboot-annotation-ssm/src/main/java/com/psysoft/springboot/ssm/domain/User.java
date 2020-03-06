package com.psysoft.springboot.ssm.domain;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
    private double money;
    @JSONField(format = "yyyy年MM月dd日")
    private Date birthday;
    @JSONField(serialize = false)
    private String remark;
}