package com.pk.juc.runnable;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class RunnableMain {
    public static void main(String[] args) {
        Runnable task=()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("ThreadName: {}, a={}", Thread.currentThread().getName(), i);
            }
        };

        new Thread(task,"RunnableTask").start();
        IntStream.range(0, 10).boxed().forEach(e -> {
            try {
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException ex) {
                log.error(ex.getMessage(), e);
            }
            log.info("ThreadName: {}, a={}", Thread.currentThread().getName(), e);
        });
    }
}
