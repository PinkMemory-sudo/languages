package com.pk.juc.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public class ThreadMain {
    public static void main(String[] args) {
        List<Integer> taskParamList = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        ThreadTask task = new ThreadTask(taskParamList);
        new Thread(task,"ThreadTask1").start();
        new Thread(task,"ThreadTask2").start();
        new Thread(task,"ThreadTask3").start();
    }
}
