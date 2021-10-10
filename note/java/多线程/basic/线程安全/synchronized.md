Java中**每个对象都有**一个与之关联的内部锁(也称作监视器)，在有线程获取该内存锁后，其它线程无法访问该内存，从而实现JAVA中简单的同步、互斥操作。

内部锁通过synchronized实现。synchronized关键字可以修饰方法和关键字。

***修饰代码块***

每个对象都可以作为锁对象，经常使用当前对象this作为锁对象，

```java
synchronized(对象锁){
    // 同步代码块中访问共享变量
}
```

***修饰实例方法***

锁对象是this



***修饰静态方法***

使用的锁对象默认是当前类的class对象

不管什么，只要使用同一个锁对象就行，及多个线程通过实例对象调用方法时保证用的时同一个实例，使用静态同步方法时保证里面的锁是同一个变量。





**一个类中有多个同步方法怎么办**

相当于多个方法使用了同一把锁,这样就变成了每次只能有一个线程执行该对象的某一个方法,应该在类中声明多把锁,使用同步代码块,最方便的是**使用字符串作为锁对象**

```java
public class Market {

    public final String saleLock="saleLock";
    public final String purchaseLock="purchaseLock";
    
    public  void sale() {
        synchronized (saleLock){
        System.out.println("sale");
        }
    }

    public void purchase() {
        synchronized (purchaseLock){
            System.out.println("Purchase");
        }
    }
}
```



**使用同步代码块还是同步方法**?

同步方法锁粒度大,如果要减少粒度,就是用同步代码块



将当前类的class对象作为锁对象





**脏读**

修改和读取都要同步









Obj.wait()，与Obj.notify()必须要与synchronized(Obj)一起使用，也就是wait,与notify是针对已经获取了Obj锁进行操作，从语法角度来说就是Obj.wait(),Obj.notify必须在synchronized(Obj){...}语句块内。从功能上来说wait就是说线程在获取对象锁后，主动释放对象锁，同时本线程休眠。直到有其它线程调用对象的notify()唤醒该线程，才能继续获取对象锁，并继续执行。相应的notify()就是对对象锁的唤醒操作。





monitor

Java中的每个对象都有一个监视器，来监测并发代码的重入

wait/notify必须存在于synchronized块中。并且，这三个关键字针对的是同一个监视器（某对象的监视器）。这意味着wait之后，其他线程可以进入同步块执行。



# 使用



**修饰代码块**



**修饰方法**



**修饰静态方法**



**修饰类**



