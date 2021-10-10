package com.pk.juc.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(10000);
        // 经过计算，结果是1
        return 1;
    }
}
