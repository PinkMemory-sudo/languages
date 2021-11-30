package com.pk.juc.vola;

import lombok.Data;

import java.util.concurrent.TimeUnit;

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

    private volatile boolean status = true;

    @Override
    public void run() {
        while (status) {
            // stdout是行缓冲的. 使用stderr,或在每次打印后刷新PrintStream.
//            System.out.println(Thread.currentThread().getName());
        }
        System.out.println(Thread.currentThread().getName() + ":" + status);
    }
}
