package com.pk.juc.three;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程原子性问题演示
 */
public class AtomicTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticket.saleAtomicClass());
                }
            }, "counter" + i).start();
        }
    }

}

class Ticket {
    private int i = 100;
    private AtomicInteger atomicNum=new AtomicInteger(100);

    public int sale() {
        return i--;
    }

    /**
     * 使用Java自带的原子性操作类解决原子性问题
     */
    public int saleAtomicClass() {
        return atomicNum.getAndDecrement();
    }
}
