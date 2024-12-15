package com.tsv.jms.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class Sender {

    private final JmsTemplate jmsTemplate;

    public void sendMessage(String destination, String message) {
        jmsTemplate.convertAndSend(destination, message);
    }

}
