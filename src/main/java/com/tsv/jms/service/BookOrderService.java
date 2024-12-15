package com.tsv.jms.service;


import com.tsv.jms.model.BookOrder;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Service
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookOrderService {

    private static final String BOOK_QUEUE = "book.order.queue";
    private final JmsTemplate jmsTemplate;

    public void send(BookOrder order) {
        jmsTemplate.convertAndSend(BOOK_QUEUE, order);
    }

}
