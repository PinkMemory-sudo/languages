package com.pk.juc.three;

import java.util.concurrent.TimeUnit;

public class NoVolatile {
    public static void main(String[] args) {
        DemonSource demonSource = new DemonSource();
        new Thread(demonSource::run).start();
        // 可以看出主线程结束不了，因为主线程读到的flag是false，另一个线程改变了flag时，主线程感知不到
        // 解决方法: 共享变量flag前加volatile
        try {
            TimeUnit.SECONDS.sleep(1);
            demonSource.changeFlag();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DemonSource {
    private boolean flag = false;
    public void run() {
        while (true) {
            if (flag) {
                break;
            }
        }
    }

    public void changeFlag() {
        // 改变状态操作需要用时1s(主线程读到改变前的flag)
        flag = !flag;
    }
}