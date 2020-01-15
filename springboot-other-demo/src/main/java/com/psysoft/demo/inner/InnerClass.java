package com.psysoft.demo.inner;

/**
 * 测试内部类是否共享资源
 */

public class InnerClass {

    private Object lock1 = new Object();

    private Object lock2 = new Object();

    public void print1() throws InterruptedException {
        synchronized (lock1){
            int i = 0;
            while ( i < 10) {
                Thread.sleep(100);
                System.out.println("print1:" + Thread.currentThread().getName());
                i++;
            }
        }
    }

    public synchronized  void print2() throws InterruptedException {
        int i = 0;
        while ( i < 10){
            Thread.sleep(100);
            System.out.println("print2:"+Thread.currentThread().getName());
            i++;
        }
    }

    public static synchronized  void print3() throws InterruptedException {
        int i = 0;
        while ( i < 10) {
            Thread.sleep(100);
            System.out.println("print2:" + Thread.currentThread().getName());
            i++;
        }
    }



}
