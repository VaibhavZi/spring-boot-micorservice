package com.vz.simple;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FinDay {
    public static String findDay(int month, int day, int year) {
        LocalDate date = LocalDate.of(year,month,day);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String s = dayOfWeek.toString();
        return s;
    }

    public static void main(String[] args) {

        System.out.println(findDay(8, 5, 2015));
    }
}
