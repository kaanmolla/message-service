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

}
