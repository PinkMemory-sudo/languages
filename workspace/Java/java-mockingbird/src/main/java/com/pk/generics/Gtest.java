package com.pk.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Test<T, V> {
    private T t;

    public T get(T key) {
        return key;
    }
}

public class Gtest {

//    private static <T> String join(T t1, T t2) {
//        return t1.toString() + t2.toString();
//    }
//
//    public static void main(String[] args) {
//        System.out.println(join("s1", "s2"));
//    }
public static void main(String[] args) {
    Stark<Integer> stark = new Stark<>();
    IntStream.range(0,10).boxed().forEach(stark::push);
    for (int i = 0; i < 10; i++) {
        System.out.println(stark.get());
    }
}
}

class Stark<T> {
    private List<T> list = new ArrayList<>();

    public T get() {
        int index = list.size() == 0 ? 0 : list.size() - 1;
        T t = list.get(index);
        synchronized (this){
            list.remove(index);
        }
        return t;
    }

    public void push(T t) {
        synchronized (this){
            list.add(t);
        }
    }
}

