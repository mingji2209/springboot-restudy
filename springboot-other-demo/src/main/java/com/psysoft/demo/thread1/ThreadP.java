package com.psysoft.demo.thread1;

public class ThreadP extends Thread {
    private P p;

    public ThreadP(P p) {
        super();
        this.p = p;
    }

    @Override
    public void run() {
       // super.run();
        while (true){
            p.setValue();
        }
    }
}
