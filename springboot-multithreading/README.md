springboot-multithreading  Java并发体系
===

1 基础
---

 
##实现多线程的方式 
继承 Thread 类、
实现 Runnable 接口、
使用 ExecutorService、Callable、Future 实现带返回结果的多线程

线程启动（为什么调用star 而不是 run）
 statr --> start0 本地方法 --> JVM_StatrtThread --> os::start_yhread --> javaThread::run
 
 线程终止 （考虑interrupt的使用）   待实现 
 
 ##锁在虚拟机上是如何储存的
 
 1 Mark Word 记录锁和对象的相关信息
 
 2 对象可以实现锁
     a Object类有一个NativeC++对象 b 就是monotor对象
     
###synchronized 锁的升级 无锁、偏向锁、轻量级锁、重量级锁


###信 号 机 制 wait/notify/notifyall，可以用于控制线程的状态

## AQS底层原理分析
  线程池、阻塞队列、计时器、同步器、并发集合

###Lock 简介
 解决并发的关键字 比syhchronized灵活
 ReentrantLock：表示重入锁 
 ReentrantReadWriteLock：重入读写锁
 StampedLock：读写锁的一个改进版本 stampedLock 是一种乐观的读策略

 new Thread(rd::demo).start();  // Runabled内部实现类 + lambda的应用符号 ::
 
 类锁和对象锁是两个不一样的锁，控制着不同的区域，它们是互不干扰的
 
 ### ReentrantLock 重入锁
 ReentrantLock的实现原理  。就是在多线程竞争重入锁时，竞争失败的线程是如何实现阻塞以及被唤醒的呢
 
 同步队列(独占和共享) AQS  FIFO 的双向链表  HEAD 指向头节点 TAIL 指向尾结点
 
  当线程争抢锁失败后会封装成 Node 加入到 ASQ 队列中去；当获取锁的线程释放锁以
  后，会从队列中唤醒一个阻塞的节点(线程)
  head 节点表示获取锁成功的节点 CAS将tail指向新加的线程节点
  
  NofairSync(新线程可以争取锁)和FairSync（FIFO执行队列的线程） 默认是NofairSync
  
  
  ###公平锁和非公平锁的区别 
  非公平锁 ： if (compareAndSetState(0, 1))  setExclusiveOwnerThread(Thread.currentThread()); 先惊喜CAS抢占
  公平锁：!hasQueuedPredecessors() 如果有 前置节点就请求失败，保证FIFO
  
  
  ###锁的释放流程
  
  
  ###Condition
  
  Condition源码分析
  
  
  
  ### 并发工具的使用以及原理
  
  CountDownLatch: 类似于join 允许一个或多个线程一直等待，直到其他线程的操作执行完毕再执行
    CountDownLatch的实现原理  待完善
    
    
    Semaphore: 
   
    CyclicBarrier : 

  
### ConcurrentHashMap



### 线程安全性原理分析


### 线程池的原理分析
“请简单说下你知道的线程池和ThreadPoolThread 有哪些构造参数

public ThreadPoolExecutor(int corePoolSize, //核心线程数量
 int maximumPoolSize, //最大线程数
 long keepAliveTime, //超时时间,超出核心线程数量以外的线程空余存活时间
 TimeUnit unit, //存活时间单位
 BlockingQueue<Runnable> workQueue, //保存执行任务的队列
ThreadFactory threadFactory,//创建新线程使用的工厂
RejectedExecutionHandler handler //当任务无法执行的时候的处理方式)

newFixedThreadPool 创建制定大小的线程 用于负载比较大的服务器，为了资源的合理利用，需要限制当前线程数量
newCachedThreadPool
newSingleThreadExecutor 任务按照指定顺序(FIFO, LIFO, 优先级)执行

####线程池的实现原理分析
execute 
