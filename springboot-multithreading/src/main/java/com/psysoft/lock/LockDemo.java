package com.psysoft.lock;

import java.time.Instant;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试多线程对共享变量的使用
 */

public class LockDemo {

    private final static int TASK_NUM = 300000;
    private final static int THREAD_NUM = 100;

    private  static int count = 0;

    static Lock lock = new ReentrantLock();

//    public static void process(){
//        ExecutorService sub_service =  Executors.newFixedThreadPool(THREAD_NUM);
//        Long start = Instant.now().getEpochSecond();
//        for (int i = 0; i <TASK_NUM ; i++) {
//            sub_service.submit(LockDemo::inc);
//        }
//        sub_service.shutdown();
//        while (true) {//等待所有任务都执行结束
//            if(sub_service.isTerminated()){
//                System.out.println("消耗时间:"+(Instant.now().getEpochSecond()-start));
//                break;
//            }
//
//        }
//    }



    public  static  void inc(){
        lock.lock();
            count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
       ExecutorService main_service =  Executors.newFixedThreadPool(THREAD_NUM);

        Long start = Instant.now().toEpochMilli();
        for (int i = 0; i <TASK_NUM ; i++) {
            main_service.submit(LockDemo::inc);
        }

        Thread.sleep(100);

       main_service.shutdown();
        while (true){
            if(main_service.isTerminated()){
                System.out.println("耗时："+(Instant.now().toEpochMilli()-start));
                break;
            }
        }
       System.out.println(count);
    }
}
