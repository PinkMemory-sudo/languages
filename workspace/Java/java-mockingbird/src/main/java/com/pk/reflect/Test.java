package com.pk.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) throws ClassNotFoundException {


        // 获得Class对象
        Class<B> bClass = B.class;
        Class<?> b = Class.forName("com.pk.reflect.B");
        B b1 = new B();
        Class<? extends B> clz = b1.getClass();

        // 获得属性
        Field[] fields = clz.getFields();
        for (Field field : fields) {
            System.out.println(field);
            // 获得注解
            System.out.println(field.getAnnotatedType());
        }

        // 获得方法
        Method[] methods = clz.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("++++++++++++++++++++++++++++++++");
        // 执行方法
        Method[] declaredMethods = clz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println((declaredMethod.getName() + declaredMethod.getParameterCount()));
        }
        System.out.println("+++++++++++++++++++++++++++++++++");
        Method getBPub = null;
        try {
            getBPub = clz.getMethod("getBPub");
            System.out.println(getBPub.invoke(b1));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("++++++++++++++++++++++++++++++++++");
        try {
            getBPub = clz.getDeclaredMethod("getPriTest");
            getBPub.setAccessible(true);
            System.out.println(getBPub.invoke(b1));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        // 私有属性

        // 私有方法
    }

}
