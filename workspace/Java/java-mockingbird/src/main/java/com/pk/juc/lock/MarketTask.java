package com.pk.juc.lock;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Data
public class MarketTask {

    ReentrantLock lock = new ReentrantLock();
    Condition product = lock.newCondition();
    Condition consumer = lock.newCondition();

    private boolean goods = false;

    /**
     * 进货
     */
    public void add() throws InterruptedException {
        lock.lock();
        try {
            while (goods) {
                product.await();
            }
            goods = true;
            System.out.println(Thread.currentThread().getName() + "lock: true");
            consumer.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 出货
     */
    public void popList() throws InterruptedException {
        lock.lock();
        try {
            while (!goods) {
                consumer.await();
            }
            goods = false;
            System.out.println(Thread.currentThread().getName() + "lock: false");
            product.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
