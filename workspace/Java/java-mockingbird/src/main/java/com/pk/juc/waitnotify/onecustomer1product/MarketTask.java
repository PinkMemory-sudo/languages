package com.pk.juc.waitnotify.onecustomer1product;

import lombok.Data;

@Data
public class MarketTask {
    private boolean goods = false;

    /**
     * 进货
     */
    public synchronized void add() throws InterruptedException {
        while (goods) {
            this.wait();
        }
        goods = true;
        System.out.println(Thread.currentThread().getName() + ": true");
        this.notifyAll();
    }

    /**
     * 出货
     */
    public synchronized void popList() throws InterruptedException {
        while (!goods) {
            this.wait();
        }
        goods = false;
        System.out.println(Thread.currentThread().getName() + ": false");
        this.notifyAll();
    }
}
