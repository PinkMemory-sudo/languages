package com.pk.juc.waitnotify.onecustomer1product;

/**
 * 生产者消费者测试
 */
public class PCtest{
    public static void main(String[] args) {
        MarketTask marketTask = new MarketTask();
        new Consumer(marketTask,"c1").start();
        new Product(marketTask,"p1").start();
        new Consumer(marketTask,"c2").start();
        new Product(marketTask,"p2").start();
    }
}

class Product extends Thread {

    private MarketTask market;

    Product(MarketTask market,String name) {
        super(name);
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                market.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {

    private MarketTask market;

    Consumer(MarketTask market,String name) {
        super(name);
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                market.popList();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
