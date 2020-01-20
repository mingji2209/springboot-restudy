package com.psysoft.jdk.defaultPublic;

/**
 * 接口的默认方法
 */

public interface Calculator {


    double sub(double a,double b);

    /**
     * 实现除法时需要判断非零操作
     * @param a
     * @param b
     * @return
     */
    double div(double a,double b);

    default double add(double a,double b){
        return a+b;
    }

    default double mul(double a,double b){
        return a-b;
    }


}
