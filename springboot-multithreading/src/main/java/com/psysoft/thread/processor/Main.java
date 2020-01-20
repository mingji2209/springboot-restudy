package com.psysoft.thread.processor;

public class Main {

    PrintProcess printProcess;

    protected Main(){
        SaveProcess saveProcess = new SaveProcess();
        saveProcess.start();
        // 停止现场
        printProcess = new PrintProcess(saveProcess);
        printProcess.start();

    }



    public static void main(String[] args) {
        Request request = new Request("Mic");
        Main main = new Main();
        main.doTest(request);

        Request request2 = new Request("Peter");
        main.doTest(request2);


    }

    private void doTest(Request request) {
        printProcess.processRequest(request);  // 加入打印请求
    }
}
