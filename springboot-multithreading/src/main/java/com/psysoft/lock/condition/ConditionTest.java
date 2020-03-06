package com.psysoft.lock.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {
    private final static int LOCAL_NUM = 10;


    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(LOCAL_NUM);


        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        service.submit(new ConditionWait(lock,condition));
        Thread.sleep(100);
        service.submit(new ConditionSingal(lock,condition));

        service.shutdown();

//        new Thread(new ConditionWait(lock,condition)).start();
//
//        new Thread(new ConditionSingal(lock,condition)).start();

    }
}
