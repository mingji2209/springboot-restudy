package com.psysoft.basic;

public class ReentrantDemo {



    public synchronized void demo(){

       // demo2();
        while (true){
            System.out.println("begin demo"+Thread.currentThread().getName());

        }
    }

    public void demo2(){
        synchronized (this){
            while (true){
                System.out.println("begin demo2"+Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        ReentrantDemo rd = new ReentrantDemo();
        new Thread(rd::demo).start();  // Runabled内部实现类 + lambda的应用符号 ::
        new Thread(rd::demo2).start();

//        new Thread(()->rd.demo()).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                rd.demo();
//            }
//        }).start();
    }
}
