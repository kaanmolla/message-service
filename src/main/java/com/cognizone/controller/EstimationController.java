package com.cognizone.controller;

import com.cognizone.service.EstimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estimations")
public class EstimationController {

    @Autowired
    private EstimationService estimationService;

    @RequestMapping(value = "/week", method = RequestMethod.GET)
    public String getMessageEstimationsDaily() {
        return "You will have nearly " + estimationService.getMessagesByDayAndMonth()  + " more messages for the rest of the week.";
    }

    @RequestMapping(value = "/day", method = RequestMethod.GET)
    public String getMessageEstimationsHourly() {
        return "You will have nearly " + estimationService.getMessagesByDayAndHour() + " more messages for the rest of the day.";
    }

}
