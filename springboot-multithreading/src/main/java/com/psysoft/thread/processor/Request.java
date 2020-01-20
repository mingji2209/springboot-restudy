package com.psysoft.thread.processor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 多线程的实际应用场景  zookeeper 异步责任链
 */

@Data
@AllArgsConstructor
public class Request {

    String name;

    @Override
    public String toString() {
        return "Request{" +"name='" + name + '\'' +"}";
    }


//    public static void main(String[] args) {
//        System.out.println(new Request("psy").toString());
//    }


}
