package com.pk.juc.sync;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Runnable task = () -> {
            person.test();
        };
        new Thread(task, "t1").start();
        new Thread(task, "t2").start();
    }

    static class Person {
        public synchronized void test() {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
