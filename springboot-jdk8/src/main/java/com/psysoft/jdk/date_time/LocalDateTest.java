package com.psysoft.jdk.date_time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTest {

    public static void main(String[] args) {
        // 查看DayOfWeak
        LocalDate date = LocalDate.of(2020,1,21);

        DayOfWeek week = date.getDayOfWeek();

        TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek.MONDAY);

        TemporalAdjuster adj2 = TemporalAdjusters.next(DayOfWeek.TUESDAY);

        TemporalAdjuster adj3 = TemporalAdjusters.next(DayOfWeek.WEDNESDAY);

        TemporalAdjuster adj5 = TemporalAdjusters.next(DayOfWeek.FRIDAY);
        TemporalAdjuster adj6 = TemporalAdjusters.next(DayOfWeek.SATURDAY);


        LocalDate sundy = date.with(adj3);

        System.out.println(sundy);

        System.out.printf("For the date of %s,  toDay is %s,next Sundy is %s.%n",date, week,sundy);
    }
}
