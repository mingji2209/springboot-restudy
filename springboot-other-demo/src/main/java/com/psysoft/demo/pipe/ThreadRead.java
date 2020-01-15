package com.psysoft.demo.pipe;

import java.io.PipedInputStream;

public class ThreadRead extends Thread{

    private ReadDate readDate;

    private PipedInputStream in;

    public ThreadRead(ReadDate readDate, PipedInputStream in) {
        this.readDate = readDate;
        this.in = in;
    }

    @Override
    public void run() {
//
        readDate.writeMethod(in);
    }
}
