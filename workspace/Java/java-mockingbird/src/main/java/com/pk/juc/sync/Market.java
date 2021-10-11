package com.pk.juc.sync;

import java.util.concurrent.TimeUnit;

public class Market {

    public final String saleLock="saleLock";
    public final String purchaseLock="purchaseLock";

    public  void sale() {
        synchronized (saleLock){
        System.out.println("sale");
        }
    }

    public void purchase() {
        synchronized (purchaseLock){
            System.out.println("Purchase");
        }
    }
}
