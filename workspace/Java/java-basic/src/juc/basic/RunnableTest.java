package juc.basic;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("hello");
        new Thread(runnable, "runnable").start();
        ThreadPoolExecutor
    }
}
