package com.pk.juc.create.runnable;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RunnableMain {
    public static void main(String[] args) {
        Runnable task=()-> {
            for (int i = 0; i < 10; i++) {
                log.info("ThreadName: {}, i={}", Thread.currentThread().getName(), i);
            }
        };
        for (int i = 0; i < 100; i++) {
            new Thread(task,"RunnableTask"+i).start();
        }
    }
}
