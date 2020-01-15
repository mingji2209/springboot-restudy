package com.psysoft.demo.pipe;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteDate {

    public void writeMethod(PipedOutputStream output){
        System.out.println("write:");
        try {
            for (int i = 0; i <300 ; i++) {
                String outData = ""+(i+1);
                output.write(outData.getBytes());
                System.out.print(outData);
            }
            System.out.println();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void writeMethod(PipedWriter output){
        System.out.println("write:");
        try {
            for (int i = 0; i <300 ; i++) {
                String outData = ""+(i+1);
                output.write(outData);
                System.out.print(outData);
            }
            System.out.println();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
