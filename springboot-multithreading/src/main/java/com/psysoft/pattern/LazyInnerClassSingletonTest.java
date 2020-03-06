package com.psysoft.pattern;

import java.lang.reflect.Constructor;

/**
 * 通过反射破解原型模式
 */
public class LazyInnerClassSingletonTest {

    public static void main(String[] args) {
        try {
            // 1 正常获取对象
            LazyInnerClassSingleton singleton = LazyInnerClassSingleton.getInstancr();

             // 2 反射获取对象
            Class<?> clazz = LazyInnerClassSingleton.class;
            //通过反射获取私有的构造方法
            Constructor c =  clazz.getDeclaredConstructor(null);
            //Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true);

            Object o1 = c.newInstance();

            Object o2 = c.newInstance();

            System.out.println(o1 == o2);

        } catch (Exception e) {
            e.printStackTrace();
        }


        // 3比较对象
    }
}
