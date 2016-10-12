package com.cognizone.utils;

import org.junit.Test;

import java.util.Date;


public class DateUtilsTest {

    @Test
    public void writeHour() {
        System.out.println(DateUtils.getHour(new Date()));
    }

    @Test
    public void writeDayOfWeek() {
        System.out.println(DateUtils.getDayofWeek(new Date()));
    }

    @Test
    public void writeDayOfMonth() {
        System.out.println(DateUtils.getDayofMonth(new Date()));
    }

    @Test
    public void writeWeek() {
        System.out.println(DateUtils.getweek(new Date()));
    }

    @Test
    public void writeMonth() {
        System.out.println(DateUtils.getMonth(new Date()));
    }

}