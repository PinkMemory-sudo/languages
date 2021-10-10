

**使用**

实现Callable<>，指定返回值类型，重写call方法

call方法可以抛出异常



Future接口来代表Callable接口里call()方法的返回值，并且为Future接口提供了一个实现类FutureTask。



## FutureTask

FutureTask即实现了Runnable，也实现了Future，所以Callable对象可以通过FutureTask来运行，也可以通过FutureTask来获得线程的执行结果