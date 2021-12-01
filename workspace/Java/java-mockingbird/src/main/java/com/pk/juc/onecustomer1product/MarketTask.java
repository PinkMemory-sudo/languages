package com.pk.juc.onecustomer1product;

import com.pk.reflect.A;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MarketTask {
    private boolean goods = false;

    /**
     * 进货
     */
    public synchronized void add() throws InterruptedException {
        if (goods) {
            this.wait(1000);
        }
        goods = true;
        System.out.println(Thread.currentThread().getName() + ": true");
        this.notifyAll();
    }

    /**
     * 出货
     */
    public synchronized void popList() throws InterruptedException {
        if (!goods) {
            this.wait(1000);
        }
        goods = false;
        System.out.println(Thread.currentThread().getName() + ": false");
        this.notifyAll();
    }
}
