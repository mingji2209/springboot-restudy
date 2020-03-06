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
    
###阻塞队列，原子操作的原理分析

  
  
### ConcurrentHashMap
api 使用
    ConcurrentHashMap 是 Map 的派生类，所以 api 基本和 Hashmap 是类似，主要就是 put、get 这些方法
    
    Node 数组来保存数据，并且采用 Node 数组元素作为锁来实现每一行数据进行加锁来进一步减少并发冲突的概率
    数组+单向链表+红黑树的结构
    
put方法的四个阶段 （*** 花点时间掌握）




### 线程安全性的原理分析
初步认识 Volatile
    读线程不能及时的读取到其他线程写入的最新的值。这就是所谓的可见性
    为了实现跨线程写入的内存可见性，必须使用到一些机制来实现。而 volatile 就是这样一种机制
    
什么叫缓存一致性呢？
    为了解决缓存不一致的问题，在 CPU 层面做了很多事情，要提供了两种解决办法  
    总线锁和缓存锁:
        总线锁定的开销比较大,需要优化控制粒度
        所以引入了缓存锁，它核心机制是基于缓存一致性协议来实现的  

JMM
    它最核心的价值在于解决可见性和有序性,解决了 CPU 多级缓存、处理器优化、指令重排序导致的内存访问问题，保证了并发场景下的可见性
    JMM 提供了一些禁用缓存以及进制重排序的方法，来解决可见性和有序性问题
    
happenBefore
它的意思表示的是前一个操作的结果对于后续操作是可见的，所以它是一种表达多个线程之间对于内存的可见性


### 线程池的实现原理分析

线程池的概念
  提前创建若干个线程放在容器里面，有任务需要处理，分配给线程池线程处理，任务执行完，线程不会被销毁，等待下次任务分配。

线程池的优势
 a 降低线程创建和销毁的性能开销
 b 提高响应速度，不需要等待创建线程创建，立即执行
 c 合理设置线程池大小可以避免线程数大于硬件资源产生的问题

Java中提供的线程池api
  Executors提供线程池方法
  
“请简单说下你知道的线程池和ThreadPoolThread 有哪些构造参数

public ThreadPoolExecutor(int corePoolSize, //核心线程数量
 int maximumPoolSize, //最大线程数
 long keepAliveTime, //超时时间,超出核心线程数量以外的线程空余存活时间
 TimeUnit unit, //存活时间单位
 BlockingQueue<Runnable> workQueue, //保存执行任务的队列
ThreadFactory threadFactory,//创建新线程使用的工厂
RejectedExecutionHandler handler //当任务无法执行的时候的处理方式)

newFixedThreadPool 创建制定大小的线程 用于负载比较大的服务器，为了资源的合理利用，需要限制当前线程数量

    public static ExecutorService newFixedThreadPool(int nThreads) {
        return new ThreadPoolExecutor(nThreads, nThreads,
                                      0L, TimeUnit.MILLISECONDS,
                                      new LinkedBlockingQueue<Runnable>());
    }
  

newCachedThreadPool 返回一个可根据实际情况调整线程个数的线程池，不限制最大线程数量，
若用空闲的线程则执行任务，若无任务则不创建线程。并且每一个空闲线程会在 60 秒后自动回收
    public static ExecutorService newCachedThreadPool() {   
     return new ThreadPoolExecutor(0, Integer.MAX_VALUE,
     60L, TimeUnit.SECONDS,
     new SynchronousQueue<Runnable>());
    }
 
newSingleThreadExecutor 任务按照指定顺序(FIFO, LIFO, 优先级)执行
newScheduledThreadPool: 创建一个可以指定线程的数量的线程池，但是这个线程池还带有
延迟和周期性执行任务的功能，类似定时器。

线程池的实现原理分析 ***
  线程池原理分析(FixedThreadPool)
  excute--源码入口（*** 需要花时间掌握）
  ctl：private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
  它是一个原子类，主要作用是用来保存线程数量和线程池的状态
  

线程池的注意事项
  线程池的构建不允许使用 Executors 去创建，而是通过 ThreadPoolExecutor 的方式。
  
  IO 密集型线程核心数计算公式：：线程池设定最佳线程数目 = （（线程池设定的线程等待时间+线程 CPU 时间）/
                  线程 CPU 时间 ）* CPU 数目
   这个公式的线程 cpu 时间是预估的程序单个线程在 cpu 上运行的时间（通常使用 loadrunner
   测试大量运行次数求出平均值）
   
线程池中的线程初始化
  默认情况下，线程池初始化时不会创建线程，可以通过以下办法实现要线程池创建之 后立即创建线程
    a prestartCoreThread():初始化一个核心线程
    b prestartAllCoreThread(): 初始化所以核心线程
    ThreadPoolExecutor tpe=(ThreadPoolExecutor)service;
    pe.prestartAllCoreThreads();

线程池的关闭
    shutdown() 和 shutdownNow()

线程池容量的动态调整
    setCorePoolSize：设置核心池大小 
    setMaximumPoolSize：设置线程池最大能创建的线程数目大小
    任务缓存队列及排队策略
        1. ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；
        2. LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默
        认为 Integer.MAX_VALUE；
        3. SynchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个
        线程来执行新来的任务。

线程池的监控
    重写beforeExcute，afterExecute,shutdown实现对线程的监控  （自己实现demo）

Callable和Futu的使用原理及分析 *** 需要花时间掌握



2020-03-06
### 单例模式详解
    应用场景：生活中有CEO，项目经理 J2EE 标 准 中 的 ServletContext 、 ServletContextConfig 等 、 
    Spring 框 架 应 用 中 的 ApplicationContext、数据库的连接池等也都是单例形式
    饿汉式：根据类初始化 
    优点：没有加任何锁、执行效率比较高，用户体验比懒汉式单例模式更好。 
    缺点：类加载的时候就初始化，不管用与不用都占着空间，浪费了内存，
    
    懒汉式：通过sycnizication
    
    注册式单例
        枚举式单例：是《Effective Java》书中推荐的一 种单例模式实现写法()
    容器式单例模式
        
    线程单例实现 ThreadLocal可以保证每个线程都是同一个实例
    
    小结：单例模式可以保证内存里只有一个实例，减少了内存的开销，
    还可以避免对资源的多重占用。单例 模式看起来非常简单，
    实现起来其实也非常简单，但是在面试中却是一个高频面试点
    
#### 原型模式与建造者模式 
    

