package com.psysoft.demo.inner;

public class OutClass {
    static class Inner{
        private Object lock = new Object();
        public void method1(){
            synchronized (lock){
                for (int i = 0; i < 10; i++) {
                    System.out.println(Thread.currentThread().getName()+"i="+i);
                    try {
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                    }
                }
            }
        }
        public  void method2(){
            synchronized (lock) {
                for (int i = 11; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }
}
