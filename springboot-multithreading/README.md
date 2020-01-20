springboot-multithreading  Java并发体系
===

1 基础
---

 
###实现多线程的方式 
继承 Thread 类、
实现 Runnable 接口、
使用 ExecutorService、Callable、Future 实现带返回结果的多线程

线程启动（为什么调用star 而不是 run）
 statr --> start0 本地方法 --> JVM_StatrtThread --> os::start_yhread --> javaThread::run
 
 线程终止 （考虑interrupt的使用）   待实现 
 
 ###锁在虚拟机上是如何储存的
 
 1 Mark Word 记录锁和对象的相关信息
 
 2 对象可以实现锁
     a Object类有一个NativeC++对象 b 就是monotor对象
     
###synchronized 锁的升级 无锁、偏向锁、轻量级锁、重量级锁


###信 号 机 制 wait/notify/notifyall，可以用于控制线程的状态

### AQS底层原理分析
  线程池、阻塞队列、计时器、同步器、并发集合
####Lock 简介
 解决并发的关键字 比syhchronized灵活
 ReentrantLock：表示重入锁 
 ReentrantReadWriteLock：重入读写锁
 StampedLock：读写锁的一个改进版本 stampedLock 是一种乐观的读策略
 
 



### 线程安全性原理分析
