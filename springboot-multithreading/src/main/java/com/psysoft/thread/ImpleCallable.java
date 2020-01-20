package com.psysoft.thread;

import java.util.concurrent.*;

public class ImpleCallable implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        ImpleCallable impleCallable = new ImpleCallable();

        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(impleCallable);
            System.out.println(future.get());
        }





        executorService.shutdown();

    }



    @Override
    public String call() throws Exception {
        double result = Math.random()*10+Math.random()*5;
        return Thread.currentThread().getName()+"执行callrable回调函数"+result;
    }


}
