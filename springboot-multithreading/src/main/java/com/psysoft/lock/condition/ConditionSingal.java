package com.psysoft.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionSingal implements Runnable {
    @Override
    public void run() {
        System.out.println("begin -ConditionDemoAsign");

        try {
            lock.lock();
            condition.signalAll();
            System.out.println("end - ConditionDemoAsign");
        } finally {
            lock.unlock();
        }
    }


    private Lock lock;
    private Condition condition;

    public ConditionSingal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }
}
