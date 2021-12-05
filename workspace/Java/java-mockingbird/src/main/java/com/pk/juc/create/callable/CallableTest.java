package com.pk.juc.create.callable;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task =()-> "hello";
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> future = executor.submit(task);
        System.out.println(future.get());
    }
}
