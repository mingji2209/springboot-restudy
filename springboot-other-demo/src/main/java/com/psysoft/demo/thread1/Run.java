package com.psysoft.demo.thread1;

/**
 * 实现多对多 消费者-生产者模式 操作值
 */
public class Run {

    public static void main(String[] args) throws InterruptedException {


     String lock = new String("");

     C c = new C(lock);
     P p = new P(lock);

     ThreadC[] cThread = new ThreadC[2];
     ThreadP[] pThread = new ThreadP[2];

        for (int i = 0; i <2 ; i++) {
            cThread[i] = new ThreadC(c);
            cThread[i].setName("c"+(i+1));
            pThread[i] = new ThreadP(p);
            pThread[i].setName("p"+(i+1));
            pThread[i].start();

            cThread[i].start();
        }

        Thread.sleep(5000);

        Thread[] threadArray = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threadArray);  // enumerate 方法的作用：
        for (Thread t:threadArray
             ) {
            System.out.println(t.getName()+""+t.getState());
        }

//    ThreadC c = new ThreadC(new C(lock));
//
//    ThreadP p= new ThreadP(new P(lock));
//
//    p.start();
//    c.start();



    }


}
