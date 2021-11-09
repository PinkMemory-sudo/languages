package com.pk.reflect;

public class B extends A {

    private String addr;

    public String getBPub() {
        return "hello" + addr;
    }

    private String getPriTest() {
        return "hi" + addr;
    }
}
