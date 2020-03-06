package com.psysoft.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {

        ExecutorService service =  Executors.newFixedThreadPool(2);

        service.submit(new ExectorThread());
        service.submit(new ExectorThread());
        service.submit(new ExectorThread());

        service.shutdown();

    }
}
