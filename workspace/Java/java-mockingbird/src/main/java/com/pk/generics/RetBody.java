package com.pk.generics;

import lombok.Data;

@Data
public class RetBody<T> {
    private String msg = "successfully";
    private int code = 1;
    private T data;


    public <E extends Comparable<E>> int test(E e1, E e2) {
        return e1.compareTo(e2);
    }
}
