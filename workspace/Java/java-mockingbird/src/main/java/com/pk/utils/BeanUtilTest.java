package com.pk.utils;

/**
 *
 */
public class BeanUtilTest {

    public static void main(String[] args) {
        try {
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Class<?> aClass = Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

