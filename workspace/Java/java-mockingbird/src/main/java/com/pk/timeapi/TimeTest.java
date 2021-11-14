package com.pk.timeapi;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class TimeTest {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2021, 1, 1);
        LocalDate date2 = LocalDate.of(2021, 1, 1);
        System.out.println(ChronoUnit.DAYS.between(date1, date2));

    }
}
