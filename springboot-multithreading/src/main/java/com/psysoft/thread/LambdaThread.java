package com.psysoft.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 利用lambda表达式构建现场
 * 函数式方法和方法引用
 */
public class LambdaThread {

    // 线程run调用的对象
   void process(){
       System.out.println("执行线程："+Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(1);

        LambdaThread thread = new LambdaThread();

        service.submit(thread::process);

        service.shutdown();
    }
}
