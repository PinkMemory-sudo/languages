

# Volatile

volatile，易变的；无定性的。

作用：使一个变量在多个线程之间可见性，并不保证原子性。可以看成Volatile变量是直接从主内存而不是本地内存读取的数据。



**代码实例**

一个线程修改值，另一个线程读不到



**volatile两个作用**

* 一个线程改变一个volatile变量时会立即写入主内存，然后是其他工作内存中的缓存失效，重新从主内存中读取
* 禁止指令重排序



**进制指令重排序**

* 当程序执行到volatile变量的读操作或者写操作时，在其前面的操作肯定全部已经进行，且结果已经对后面的操作可见；在其后面的操作肯定还没有进行；

* 在进行指令优化时，不能将在对volatile变量访问的语句放在其后面执行，也不能把volatile变量后面的语句放到其前面执行。



**使用volatile的场景**

对变量的写操作不依赖当前值，该变量没有包含在有其他变量的表达式中。即保证对这个变量的操作都是原子性的才能够使用。

* 标记位
* double check时



**Volatile与Synchronized的区别**

性能

作用范围





先看一种现象

```java
public class VolatileTest {
    public static void main(String[] args) {
        Task task = new Task();
        new Thread(task, "task1").start();
        // 休眠100ms，保证task1先执行
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        task.setStatus(false);
        System.out.println(Thread.currentThread().getName() + ":" + task.isStatus());
    }
}

@Data
class Task implements Runnable {

    private boolean status = true;

    @Override
    public void run() {
        while (status) {
            // stdout是行缓冲的. 使用stderr,或在每次打印后刷新PrintStream.
//            System.out.println(Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + ":" + status);
    }
}
```

可以看到一个现象，task1一直无法结束。由JMM我们直到，线程操作共享变量是不直接在主内存中操作，而是读取到本地内存中，来操作副本。所以主线程修改并更新了status的值后，task1的本地变量的值并未发生变化导致一致无法结束。

status通过volatile修饰后，task1可以正常结束

```java
private volatile boolean status = true;
```



关于Volatile的作用，可以理解成被Volatile修饰的变量，线程直接在主内存中操作(从执行效果角度看)