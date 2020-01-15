package com.psysoft.demo.thread1;

/**
 * 消费者模型
 */
public class C {
    private String lock;

    public C(String lock){
      this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                if(ValueObject.value.equals("")){
                    System.out.println("消费者"+Thread.currentThread().getName()+"Waiting");
                    lock.wait();
                }
                System.out.println("消费者"+Thread.currentThread().getName()+"Runabled");
                System.out.println("get的值是"+ValueObject.value);
                lock.notify();
                ValueObject.value = "";

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
