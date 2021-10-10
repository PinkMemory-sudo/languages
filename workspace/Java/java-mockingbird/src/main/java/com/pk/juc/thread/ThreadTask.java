package com.pk.juc.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ThreadTask extends Thread {

    List<Integer> taskParamList;

    public ThreadTask(List<Integer> taskParamList) {
        this.taskParamList = taskParamList;
    }

    public void sale() {
        while (taskParamList.size() > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
                taskParamList.remove(taskParamList.size() - 1);
            } catch (InterruptedException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Override
    public void run() {
        sale();
    }
}
