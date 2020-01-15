package com.psysoft.demo.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 需要解决读取数据缺失问题
 */

public class Run {

    public static void main(String[] args) {
        try {
            WriteDate writeDate = new WriteDate();
            ReadDate readDate = new ReadDate();
            PipedInputStream in = new PipedInputStream();
            PipedOutputStream out = new PipedOutputStream();
           // in.connect(out);
            out.connect(in);
            ThreadWrite write = new ThreadWrite(writeDate,out);
            ThreadRead read = new ThreadRead(readDate,in);
            read.start();
            Thread.sleep(1000);
            write.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
