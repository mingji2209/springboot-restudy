package com.psysoft.demo.thread1;

public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        super();
        this.c = c;
    }

    @Override
    public void run() {
       // super.run();
        while (true){

           c.getValue();
        }
    }
}
