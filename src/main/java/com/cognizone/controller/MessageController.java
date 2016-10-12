package com.cognizone.controller;

import com.cognizone.model.Message;
import com.cognizone.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Message getMessage(@RequestParam(name = "id") Long id) {
        return messageService.getMessageById(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Message createMessage(@RequestBody Message message) {
        messageService.saveMessage(message);
        return message;
    }
}
