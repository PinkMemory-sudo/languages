**Executor**



# **ExecutorService**

该接口继承Executor接口，还提供了终止的方法和追踪任务进度的方法(返回一个Future)

ExecutorService关闭后将不再接受新的task。

两种关闭Executor的方法：

* shutdown 允许之前提交的task在关闭前继续运行
* shutdownNow 组织在等待的task并且会尝试关闭当前正在执行的的task

 任务终止后，没有在运行的task，也没有在等待的task，并且也不会接受提交的task

`execute`

`submit`

延展了execute方法，会创建并返回一个Future来跟踪任务状态



`invoke`

`invokeAny`，`invvokeAll`，批量执行，等待至少一个/全部结果



# AbstractExecutorService



继承了ExecutorService，实现了里面的submit和invokeAll，invokeAny





# ThreadPoolExecutor

* 继承了AbstractExecutorService。
* 是一个ExecutorService，它是通过线程池中的几个线去执行任务。
* 提供了很多工厂方法去获得Executor。
* 每个线程池还维护了一些统计信息，如完成的任务的个数



？ 

常用的几个线程池

几个参数

运行时线程数的变化

* 什么是守护进程



各个线程池的使用场景？

CachedThreadPool

FixedThreadPool

SingleThreadExecutor



**Core and maximum pool sizes**

核心线程数<最大线程数

ThreadPoolExecutor会根据核心线程数和最大线程数自动调整线程池的大小。

当一个新任务提交后，如果当前使用的线程数小于核心线程数，就会创建一个新进程运行任务。

如果当前线程数在核心线程数和最大线程数之间，没有多余的线程是也会创建新的线程。

* 核心线程数与最大线程数相同时就是固定大小的线程池。
* maximumPoolSize设置为无界，则允许池容纳任意并发任务的数量
* 最典型的动态更改



**ThreadFactory**

新线程通过ThreadFactory创建，如果没有指定，将使用defaultThreadFactory，创建出来的线程在同一个ThreadGroup，并且是同样的优先级和非守护进程的状态



**Keep-alive times**

如果当前线程数超过核心线程数时，多出的线程将会在指定时间后关闭

？ 为0的场景？



**Queuing**





**Rejected tasks**



