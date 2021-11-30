package com.pk.juc.atomic.fieldupdater;

import lombok.Data;

@Data
public class User {
    volatile int grade;
}
