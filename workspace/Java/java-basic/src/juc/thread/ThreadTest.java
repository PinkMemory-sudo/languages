package juc.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest extends Thread {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("1");
        } catch (InterruptedException ignored) {
        }
    }

    public static void main(String[] args) {
        ThreadTest thread1 = new ThreadTest();
        thread1.start();
        /**
         * 生产者消费者模型
         */
    }
}
