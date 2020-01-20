package com.psysoft.thread.processor;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintProcess extends Thread implements RequestProcess {


    LinkedBlockingQueue<Request> requests = new LinkedBlockingQueue<>();

    private   RequestProcess nexttProcess;

    boolean isAlive = true;

    public PrintProcess(RequestProcess requestProcess){
        this.nexttProcess = requestProcess;
    }
    @Override
    public void processRequest(Request request) {
        System.out.println("新增打印队列"+request.getName());
        requests.add(request);
    }

    @Override
    public void run() {

       while (isAlive){
           try {
               System.out.println("获取打印队列");
               Request request = requests.take(); // 使用队列处理
               System.out.println("print data:"+request.getName());
               nexttProcess.processRequest(request); // 加入下一个处理（保存）请求
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
