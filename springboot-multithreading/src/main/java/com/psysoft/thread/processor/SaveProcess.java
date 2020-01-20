package com.psysoft.thread.processor;

import java.util.concurrent.LinkedBlockingQueue;

public class SaveProcess extends Thread implements RequestProcess {

    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    boolean isAlive = true;

    @Override
    public void processRequest(Request request) {
        System.out.println("新增保存队列"+request.getName());
        requests.add(request);
    }


    @Override
    public void run() {
        while (isAlive){
            Request request = null;
            try {
                System.out.println("获取保存队列");
                request = requests.take();
                System.out.println("begin save"+request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
