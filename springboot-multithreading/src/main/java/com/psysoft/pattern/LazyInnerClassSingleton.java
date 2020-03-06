package com.psysoft.pattern;

/**
 *   静态内部类兼顾饿汉式单例模式的内存浪费问题和 synchronized 的性能问题 完美避开两个缺点
 */

public class LazyInnerClassSingleton {

    private LazyInnerClassSingleton(){
        if(LazyHolder.LAZY != null){
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    // 这一步很重要
    public static final LazyInnerClassSingleton getInstancr(){
        return LazyHolder.LAZY;
    }

    // 默认不加载
    private  static class LazyHolder{
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }
}
