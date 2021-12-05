package com.pk.juc.create.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    public static void main(String[] args) {
        FutureTask<String> task= new FutureTask<>(() -> "hello");
        new Thread(task,"thread1").start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
