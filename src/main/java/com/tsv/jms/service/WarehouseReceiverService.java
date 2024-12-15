package com.tsv.jms.service;

import com.tsv.jms.model.BookOrder;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WarehouseReceiverService {

    //@JmsListener(destination = "book.order.queue")
    public void receive(BookOrder order){
        log.info("Receive message");
        log.info("Message: {}", order);

    }

}
