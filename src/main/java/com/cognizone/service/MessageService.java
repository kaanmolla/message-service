package com.cognizone.service;


import com.cognizone.model.Message;
import com.cognizone.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MessageService {

    private final AtomicLong idGenerator = new AtomicLong(1);
    private final Map<Long, Message> messages = new HashMap<>();
    private final int DAYS_OF_WEEK = 7;
    private final int HOURS_OF_DAY = 24;

    public void saveMessage(Message message) {
        message.setId(idGenerator.getAndIncrement());
        message.setSentDate(DateUtils.getFormattedDate(new Date()));
        messages.put(message.getId(), message);
    }

    public Message getMessageById(Long id) {
        return messages.get(id);
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public int getMessagesByDayAndMonth() {
        float count = 0;
        final Date currentDate = new Date();
        for (Message message : messages.values()) {
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
        for (Message message : messages.values()) {
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
