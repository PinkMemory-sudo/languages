package com.pk.designMode.singleton;

/**
 * 懒汉式，使用的时候再创建实例
 */
public class Lazy {

    // 由单例模式自己提供一个自己的实例。保证有线程创建时其他线程能够看到
    private volatile static Lazy instance;

    // 私有化构造方法
    private Lazy() {
    }

    // 对外提供获得实例的方法
    public static Lazy getInstance() {
        if (null == instance) {
            synchronized (Lazy.class) {
                if (null == instance) {
                    instance = new Lazy();
                }
            }
        }
        return instance;
    }
}
