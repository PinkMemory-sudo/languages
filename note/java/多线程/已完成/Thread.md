**实现了Runnable**



# 构造方法

构造方法由父线程执行(创建线程)，run方法由子线程执行

| 方法                                                         | 描述                           |
| ------------------------------------------------------------ | ------------------------------ |
| Thread(Runnable target, String name)                         | 设置线程名称有助于可读性和调试 |
| Thread(Runnable target)                                      |                                |
| (Runnable target, AccessControlContext acc)                  |                                |
| Thread(ThreadGroup group, Runnable target)                   |                                |
| Thread(String name)                                          |                                |
| Thread(ThreadGroup group, String name)                       |                                |
| Thread(ThreadGroup group, Runnable target, String name)      |                                |
| Thread(ThreadGroup group, Runnable target, String name,              long stackSize) |                                |

构造方法都是调用Thread的`init(g, target, name, stackSize, null)`,所以我们可以设置的就是线程组，任务，线程名，栈大小(<=0时，以-Xss为准)



# 静态方法

| 方法                                                         | 描述                                  |
| ------------------------------------------------------------ | ------------------------------------- |
| public static native Thread currentThread()                  | 获得当前正在执行的线程实例            |
| public static native void yield()                            | 释放CPU执行权，转就绪态(但不会释放锁) |
| static native void sleep(long millis)                        | 休眠，不释放锁                        |
| public static void sleep(long millis, int nanos)             |                                       |
| public static boolean interrupted()                          | 清除interrupted status                |
| public static int activeCount()                              | 估算当前线程组(和子组)活跃线程数      |
| public static int enumerate(Thread tarray[])                 | 将多个线程拷贝到当前线程组            |
| public static void dumpStack()                               | 仅用来测试，打印栈信息                |
| public static native boolean holdsLock(Object obj)           | 该线程是否持有该锁                    |
| public static Map<Thread, StackTraceElement[]> getAllStackTraces() |                                       |
| public static void setDefaultUncaughtExceptionHandler(UncaughtExceptionHandler eh) | 线程出现异常怎么办                    |
| public static UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() | 获得线程默认的处理器                  |



# 实例方法

| 方法          | 描述                                                         |
| ------------- | ------------------------------------------------------------ |
| start()       | 开启线程，线程什么时候执行由操作系统的线程调度器决定，并不一定按照start的顺序 |
| join          | 将该线程添加到当前正在执行的线程，该线程执行完后当前线程再接着执行，可以设置等待时间long millis, int nanos。 |
| isAlive       | 判断线程是否还活着(已经启动，没有终止)                       |
| gitId         | 获得线程号，线程接续后，线程号可能被其他线程重新利用         |
| setPriority   | 取值范围1-10其他的会抛出异常，具有继承性，使用默认的就行，从程序逻辑上下手改吧，这个可控性不强，*setPriority*不一定起作用的，在不同的操作系统不同的jvm上，效果也可能不同 |
| interrupt     | 仅仅是将该线程标记为中断，子线程没有真正中断。被阻塞和休眠的线程会立即解放出来，抛出异常 |
| isInterrupted | 判断当前线程是否被标记为中断                                 |
| setDaemon     | 设置成守护线程                                               |
| getState      | 获得线程的状态                                               |





# 线程的六种状态



线程的状态可以通过Thread的实例方法getState()获得



**线程的状态(getStatus获)**

| 状态          | 描述                                                         |
| ------------- | ------------------------------------------------------------ |
| NEW           | 新建状态                                                     |
| RUNNABLE      | 可运行状态，包含READY和RUNNING                               |
| BLOCKED       | 阻塞状态，线程发起阻塞的I/O操作或者申请其他线程占用的资源(锁等)时。阻塞状态不会占用CPU |
| WAITING       | 等待状态，线程执行了wait或者join状态，执行notify或者加入的线程执行完后进入RUNNABLE |
| TIMED_EAITING | 与WAITING状态类似，但是指定的有时间，超时自动转RUNNABLE      |
| TERMINATED    | 线程运行完之后                                               |



![1638073726649](C:\Users\11942\AppData\Roaming\Typora\typora-user-images\1638073726649.png)

![1638631943116](E:\note\languages\note\img\1638631943116.png)



