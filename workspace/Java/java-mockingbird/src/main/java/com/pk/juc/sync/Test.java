package com.pk.juc.sync;

public class Test {
    public static void main(String[] args) {
        Market market = new Market();
        new Thread(market::purchase).start();
        new Thread(market::sale).start();
    }
}
