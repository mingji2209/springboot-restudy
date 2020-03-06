package com.psysoft.basic;

import java.util.concurrent.TimeUnit;

public class InterruptDemo {

    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
//            while (!Thread.currentThread().isInterrupted()){
//               i++;
//            }
//            System.out.println("Num:"+i);
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("before"+Thread.currentThread().isInterrupted());
                    Thread.interrupted();
                    System.out.println("after"+Thread.currentThread().isInterrupted());
                }
            }
        },"thread_demo");
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (Thread.currentThread().isInterrupted()){
//               i++;
//                }
//                System.out.println("Num:"+i);
//            }
//        },"thread_demp");
        thread.start();
        TimeUnit.NANOSECONDS.sleep(1);
        thread.interrupt();
    }
}
