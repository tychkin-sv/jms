package com.tsv.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	/*
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		Sender sender = context.getBean(Sender.class);

		log.info("Preparing to send a message");
		sender.sendMessage("order-queue", "Hello");
		*/
    }


}
