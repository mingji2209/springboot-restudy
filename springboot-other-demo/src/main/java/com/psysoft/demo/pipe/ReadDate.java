package com.psysoft.demo.pipe;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedReader;
import java.nio.charset.Charset;

/**
 * 使用pppe管道处理线程之间数据的传递
 */

public class ReadDate {

    //字节读取
    public void writeMethod(PipedInputStream input){

        System.out.println("read:");
        byte[] array = new byte[1024];
        try {
            int readLine = input.read(array);
//            int count = input.available();
//            System.out.println("count="+input.available());
            while (readLine != -1){
                String newData = new String(array,0,readLine, Charset.forName("utf-8"));
                System.out.print(newData);
                readLine=input.read(array);
            }
            System.out.println();

            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符读取
    public void writeMethod(PipedReader input){
        System.out.println("read:");
        byte[] array = new byte[1024];
        try {
            int readLine = input.read();
            while (readLine != -1){
                String newData = new String(array,0,readLine);
                System.out.print(newData);
                readLine = input.read();
            }
            System.out.println();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
