package com.psysoft.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImplRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("执行"+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1);


       ImplRunable t = new ImplRunable();


        service.submit(t);

        service.shutdown();
    }
}
