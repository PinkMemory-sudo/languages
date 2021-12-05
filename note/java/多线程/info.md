





# 线程组

默认属于父线程所在的线程组，不常用

创建线程组 

基本操作

|                    |      |
| ------------------ | ---- |
| 活动线程数(近似值) |      |
|                    |      |
|                    |      |



# 捕获线程的异常



![1638548265430](C:\Users\11942\AppData\Roaming\Typora\typora-user-images\1638548265430.png)

![1638548292333](C:\Users\11942\AppData\Roaming\Typora\typora-user-images\1638548292333.png)

线程出现异常时，JVM或调用Thread类中的dispatchUncaughtException(Throwable e)方法。该方法调用getUncaughtExceptionHandler.uncaughtException

run方法中的异常必须捕获。如果想要获得run()方法中出现的运行时异常，可以通过回掉UncaughtExceptionHandler接口获得哪个线程出现了异常，

Thread类中处理异常的方法

getDefaultUncaughtExch



**线程回调接口**

开发中挺常用的

![1638548398209](C:\Users\11942\AppData\Roaming\Typora\typora-user-images\1638548398209.png)



![1638548636546](C:\Users\11942\AppData\Roaming\Typora\typora-user-images\1638548636546.png)

![1638548702925](C:\Users\11942\AppData\Roaming\Typora\typora-user-images\1638548702925.png)