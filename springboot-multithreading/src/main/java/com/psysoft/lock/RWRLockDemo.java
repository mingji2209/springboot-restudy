package com.psysoft.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 */
public class RWRLockDemo {

   static Map<String,Object> cacheMap = new HashMap<>();

    static  ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
    static Lock read = rrwl.readLock();
    static Lock write = rrwl.writeLock();

    public static final Object get(String key){

        System.out.println("开始读取数据");
        write.lock();
        try{
            return cacheMap.get(key);
        }finally {
            write.unlock();
        }
    }

    public static final void put(String key,Object value){
        write.lock();
        System.out.println("开始写数据");
        try{
             cacheMap.put(key,value);
        }finally {
            write.unlock();
        }
    }
}
