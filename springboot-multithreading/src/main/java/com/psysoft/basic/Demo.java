package com.psysoft.basic;

/**
 * 测试多线程对共享变量的使用
 */

public class Demo {

    private  static int count = 0;

    public  static  void inc(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(Demo.class){
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <1000 ; i++) {
            new Thread(()->Demo.inc()).start();
        }
        Thread.sleep(4000);
        System.out.println(count);
    }
}
