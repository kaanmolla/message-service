package com.cognizone.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateService {

    private final Logger LOG = Logger.getLogger(DateService.class.getName());
    private final String DATE_FORMAT = "yyyy-MM-dd hh:mm";

    public Date getCurrentDate() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat(DATE_FORMAT);
        String str = dateFormatter.format(new Date());
        Date sentDate = null;
        try {
            sentDate = dateFormatter.parse(str);
        } catch (ParseException e) {
            LOG.error("CAN NOT PARSE DATE", e);
        }

        System.out.println(sentDate);
        return sentDate;
    }

}
