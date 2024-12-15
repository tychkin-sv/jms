package com.tsv.jms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Book {

    private final String id;
    private final String title;

}
