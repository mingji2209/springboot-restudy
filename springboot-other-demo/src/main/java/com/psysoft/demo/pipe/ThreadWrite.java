package com.psysoft.demo.pipe;

import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {

    private WriteDate writeDate;
    private PipedOutputStream out;

    public ThreadWrite(WriteDate writeDate,PipedOutputStream out){
        this.writeDate = writeDate;
        this.out = out;
    }

    @Override
    public void run() {
        //super.run();
        writeDate.writeMethod(out);
    }
}
