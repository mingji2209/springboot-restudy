package com.psysoft.jdk.LambdaExp;

import java.util.concurrent.TimeUnit;

public class RunnableTest {







    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程："+Thread.currentThread().getName());
            }
        });

        Thread thread2 = new Thread(()-> System.out.println("当前线程："+Thread.currentThread().getName()));

        thread1.start();

        thread2.start();
    }


}
