package com.psysoft.demo.thread1;

/**
 * 生产者模型
 */
public class P {
    private String lock;

    public P(String lock){
      this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                if(!ValueObject.value.equals("")){
                    System.out.println("生产者"+Thread.currentThread().getName()+"Waiting");
                    lock.wait();
                }
                System.out.println("生产者"+Thread.currentThread().getName()+"Runabled");
                String value = System.currentTimeMillis()+"-"+System.nanoTime();
                System.out.println("set的值是"+value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
