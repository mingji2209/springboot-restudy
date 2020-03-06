package com.psysoft.until;

import com.psysoft.thread.ImplRunable;

import java.util.concurrent.CountDownLatch;

/**
 * 模拟高并发下CountDownLatch的应用
 */
public class Demo {

    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        ImplRunable runable = new ImplRunable(latch);

        for (int i = 0; i <1000 ; i++) {
            new Thread(runable).start();
        }
        System.out.println("Main:"+Thread.currentThread().getName());
        latch.countDown();
    }
}
