package com.psysoft.until;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 只要执行了满足的前置就继续执行
 */
public class CountDownLatchTest {

    private static final int TASK_NUM = 10;

    static CountDownLatch latch = new CountDownLatch(TASK_NUM);

    private static final int THREAD_NUM = 6;


    static int a = 0;
    static int b = 0;
    static int c = 0;





    static void task1(){
       latch.countDown();
        System.out.println("a");
        a += 1;
    }

    static void task2(){
        latch.countDown();
        b += 1;
        System.out.println("b");
    }

    static void task3(){
        latch.countDown();
        c +=1;
        System.out.println("c");
    }

    static void task(){
        task1();task2();task3();
    }



    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(TASK_NUM);
        for (int i = 0; i <4 ; i++) {
            service.submit(CountDownLatchTest::task);
        }
        latch.await(); // 只要保证了满足最少条件就继续下一步
        System.out.println("result:"+a+b+c);


        service.shutdown();




    }
}
