package com.pk.classload;

public class CLtest {
    public static void main(String[] args) {
        Person person = new Person();
    }
}

class Person{

    {
        System.out.println("{}");
    }

    Person(){
        System.out.println("Person()");
    }
}
