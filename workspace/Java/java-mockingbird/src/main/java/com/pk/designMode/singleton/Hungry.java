package com.pk.designMode.singleton;

/**
 * 饿汉式，直接创建好对象，对外提供一个获得实例的方法
 */
public class Hungry {

    private static Hungry instance;

    private Hungry() {
    }

    private static Hungry getInstance() {
        return instance;
    }
}
