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
        ThreadTask task = new ThreadTask();
        new Thread(task,"Counter1").start();
        new Thread(task,"Counter2").start();
        new Thread(task,"Counter3").start();

    }
}
