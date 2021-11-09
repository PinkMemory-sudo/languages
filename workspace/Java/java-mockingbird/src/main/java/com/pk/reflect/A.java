package com.pk.reflect;

public class A {
    private String name;
    private int age;

    public String getPub() {
        return name + age;
    }

    private String getPri() {
        return name + age;
    }
}
