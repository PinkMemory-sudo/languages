package com.pk.juc.prodcos;

import java.util.ArrayList;
import java.util.List;

/**
 * 商店，包含进货和出货
 */
public class Goods {

    private List<String> foodList = new ArrayList<>();

    private void add(String food) {
        synchronized (this) {
            if (foodList.size() > 5) {
                this.notify();
            }
        }
    }

    private String get() throws InterruptedException {
        synchronized (this) {
            if (foodList.size() < 1) {
                this.wait();
            }
        }
        return "";
    }

}
