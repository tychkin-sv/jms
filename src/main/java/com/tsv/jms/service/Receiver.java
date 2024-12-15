package com.tsv.jms.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Receiver {

    @JmsListener(destination = "order-queue")
    public void receiveMessage(String message){
        log.info("Order received is : {}", message);
    }
}
