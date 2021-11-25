package com.pk.annotation;

import lombok.Data;

@Data
public class Entity {
    private String name;
    private String company;
    @MyAnnotation("薪水")
    private String salary;
}
