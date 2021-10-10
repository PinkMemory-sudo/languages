定义一个类，包括它的资源，和它对资源的处理方法，这样就可以通过调用它的方法来处理它的资源。



多线程，资源很大，我自己调用它的方法比较慢，能不能多个人同时使用这个方法进行操作。



线程和线程执行的任务是分开的，我们写的实际就是线程执行的任务。

1. 实现Runnable或者继承Thread
2. 创建多个线程共同执行这个任务



有一堆任务需要一个个执行,每个任务需要执行10分钟

```java
@Slf4j
public class ThreadTask extends Thread {

		List<Integer> taskParamList;

    public ThreadTask(List<Integer> taskParamList) {
        this.taskParamList = taskParamList;
    }

    public void sale() {
        while (taskParamList.size() > 0) {
            try {
                TimeUnit.MINUTES.sleep(100);
                taskParamList.remove(taskParamList.size() - 1);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
```



能不能让多个任务同时执行？

继承Thread，然后将这个任务分给多个线程

