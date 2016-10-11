package com.cognizone.utils;


import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final Logger LOG = Logger.getLogger(DateUtils.class.getName());
    private static final String DATE_FORMAT = "yyyy-MM-dd hh:mm";

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);

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
