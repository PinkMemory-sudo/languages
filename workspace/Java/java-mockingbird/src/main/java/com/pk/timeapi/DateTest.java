package com.pk.timeapi;

import sun.jvm.hotspot.utilities.Interval;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class DateTest {

    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = date1.plusMonths(1);
        Duration duration = Duration.between(date1, date2);
        Period period = Period.between(date1, date2);

        ChronoUnit.DAYS.between(date1,date2);
        Instant start = Instant.now();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        System.out.println(ChronoUnit.MICROS.between(start,end));

    }
}
