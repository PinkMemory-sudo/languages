package com.pk.juc.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class AtomicTest {
    public static void main(String[] args) throws InterruptedException {
        // 模拟用户登录，有一定概率登录失败
        AtomicLongCounter counter = AtomicLongCounter.getInstance();
        Runnable userLogin = () -> {
            counter.newRequest();
            double random = Math.random();
            if (random > 0.9) {
                counter.failRequest();
            } else {
                counter.successRequest();
            }
        };

        for (int i = 0; i < 10000; i++) {
            new Thread(userLogin,"Thread"+i).start();
        }

        TimeUnit.SECONDS.sleep(1);
        log.info("total:{},success:{},fail:{}",  counter.getTotalCount(),
                counter.getSuccessCount(), counter.getFailCount());
    }
}

