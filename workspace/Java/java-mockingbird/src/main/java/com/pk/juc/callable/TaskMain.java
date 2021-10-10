package com.pk.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TaskMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableTask task = new CallableTask();
        FutureTask<Integer> futureTask1 = new FutureTask<>(task);
        FutureTask<Integer> futureTask2 = new FutureTask<>(task);
        FutureTask<Integer> futureTask3 = new FutureTask<>(task);
        new Thread(futureTask1, "CallableTask1").start();
        new Thread(futureTask2, "CallableTask2").start();
        new Thread(futureTask3, "CallableTask3").start();
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask3.get());
    }
}
