package com.pk.juc.create.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadMain {
    public static void main(String[] args) {
        new ThreadTask().start();
        new ThreadTask().start();
        new ThreadTask().start();
    }
}
@Slf4j
class ThreadTask extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            log.info(Thread.currentThread().getName() + ":" + i);

        }
    }
}

