package com.pk.designMode.singleton;

public class MainClass {

    public static void main(String[] args) {
        // 懒汉式
        Lazy lazy1 = Lazy.getInstance();
        Lazy lazy2 = Lazy.getInstance();
        System.out.println(lazy1==lazy2);

    }
}
