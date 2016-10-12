package com.cognizone.service;

import com.cognizone.model.Message;
import com.cognizone.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EstimationService {

    private final int DAYS_OF_WEEK = 7;
    private final int HOURS_OF_DAY = 24;

    @Autowired
    private MessageService messageService;

    public int getMessagesByDayAndMonth() {
        float count = 0;
        final Date currentDate = new Date();
        for (Message message : messageService.getAllMessages()) {
            if (DateUtils.getWeekOfYear(currentDate) == DateUtils.getWeekOfYear(message.getSentDate())
                    && DateUtils.getDayofWeek(currentDate) >= DateUtils.getDayofWeek(message.getSentDate())) {
                count++;
            }
        }

        float totalDays = DateUtils.getDayofWeek(currentDate);

        float estimationForRestOfTheDay = getMessagesByDayAndHour();

        count += estimationForRestOfTheDay;

        float dailyMessageCount = count / totalDays;
        return Math.round(dailyMessageCount * (DAYS_OF_WEEK - totalDays));
    }

    public int getMessagesByDayAndHour() {
        float count = 0;
        final Date currentDate = new Date();
        for (Message message : messageService.getAllMessages()) {
            if (DateUtils.getWeekOfYear(currentDate) == DateUtils.getWeekOfYear(message.getSentDate())
                    && DateUtils.getDayofWeek(currentDate) == DateUtils.getDayofWeek(message.getSentDate())) {
                count++;
            }
        }

        float totalHours = DateUtils.getHour(currentDate);
        float dailyMessageCount = count / totalHours;
        return Math.round(dailyMessageCount * (HOURS_OF_DAY - totalHours));
    }

}
