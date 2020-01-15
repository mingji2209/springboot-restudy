package com.psysoft.demo.inner;

public class RunInner {

    public static void main(String[] args) {
        InnerClass inner = new InnerClass();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    inner.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    inner.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    InnerClass.print3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C");

        t1.start();
        t2.start();
       // t3.start();
    }
}
