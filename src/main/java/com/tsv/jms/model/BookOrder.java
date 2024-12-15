package com.tsv.jms.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookOrder {

    @JsonProperty("bookOrderId")
    private final String id;
    @JsonProperty("book")
    private final Book book;
    @JsonProperty("customer")
    private final Customer customer;
}
