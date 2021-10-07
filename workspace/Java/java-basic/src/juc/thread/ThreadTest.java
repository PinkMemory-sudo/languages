package juc.thread;

import java.util.concurrent.TimeUnit;

public class ThreadTest extends Thread {

    private String msg="hello";

    public ThreadTest() {
    }

    public ThreadTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(msg);
        } catch (InterruptedException ignored) {
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ThreadTest("myThread"));
        thread1.start();
        /**
         * 生产者消费者模型
         */
    }
}
