monitor

Java中的每个对象都有一个监视器，来监测并发代码的重入

wait/notify必须存在于synchronized块中。并且，这三个关键字针对的是同一个监视器（某对象的监视器）。这意味着wait之后，其他线程可以进入同步块执行。

