package com.pk.annotation;

import java.lang.reflect.Field;

class Person{

    @MyAnnotation("Tony")
    private String company;
}

public class MyAnnotationTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Person person = new Person();
        Class<Person> aClass = Person.class;
        Field field = aClass.getDeclaredField("company");
        MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());
    }
}
