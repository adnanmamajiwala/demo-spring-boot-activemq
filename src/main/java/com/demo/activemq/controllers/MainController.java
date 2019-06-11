package com.demo.activemq.controllers;

import com.demo.activemq.models.Person;
import lombok.RequiredArgsConstructor;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final JmsTemplate jmsTemplate;
    private final ActiveMQTopic activeMQTopic;

    @PostMapping("/person")
    @ResponseStatus(HttpStatus.CREATED)
    public void sample(@RequestBody Person person) {
        jmsTemplate.convertAndSend(activeMQTopic, person);
    }
}
