package com.psysoft.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExtendThread extends Thread {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);

        Thread t = new ExtendThread();
        t.setName("ExtendThread");

        service.submit(t);

        service.shutdown();


    }


    @Override
    public void run() {
        System.out.println("执行"+Thread.currentThread().getName());
    }
}
