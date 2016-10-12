package com.cognizone.utils;


import org.apache.log4j.Logger;
import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final Logger LOG = Logger.getLogger(DateUtils.class.getName());
    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm";

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);

    public static int getHour(Date date) {
        DateTime dt = new DateTime(date);

        return dt.getHourOfDay();
    }

    public static int getDayofWeek(Date date) {
        DateTime dt = new DateTime(date);

        return dt.getDayOfWeek();
    }

    public static int getDayofMonth(Date date) {
        DateTime dt = new DateTime(date);

        return dt.getDayOfMonth();
    }

    public static int getMonth(Date date) {
        DateTime dt = new DateTime(date);

        return dt.getMonthOfYear();
    }

    public static int getWeekOfYear(Date date) {
        DateTime dt = new DateTime(date);

        return dt.getWeekOfWeekyear();
    }

    public static Date getFormattedDate(Date date) {
        String dateAsString = getFormattedDateAsString(date);
        Date sentDate = null;
        try {
            sentDate = dateFormatter.parse(dateAsString);
        } catch (ParseException e) {
            LOG.error("CAN NOT PARSE DATE", e);
        }

        return sentDate;
    }

    public static String getFormattedDateAsString(Date date) {
        return dateFormatter.format(date);
    }

}
