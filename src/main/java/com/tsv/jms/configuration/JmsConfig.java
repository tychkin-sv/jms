package com.tsv.jms.configuration;

import com.tsv.jms.model.Book;
import com.tsv.jms.model.BookOrder;
import com.tsv.jms.model.Customer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MarshallingMessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
@EnableJms
public class JmsConfig {

    private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";

    //@Bean
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();

        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @Bean
    public MessageConverter xmlMarshalingMessageConverter() {
        MarshallingMessageConverter converter = new MarshallingMessageConverter(xmlStreamMarshaller());
        converter.setTargetType(MessageType.TEXT);

        return converter;
    }

    @Bean
    public XStreamMarshaller xmlStreamMarshaller(){
        XStreamMarshaller marshaller = new XStreamMarshaller();
        marshaller.setSupportedClasses(Book.class, Customer.class, BookOrder.class);

        return marshaller;
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("admin",
                "admin",
                DEFAULT_BROKER_URL);
    }

    @Bean
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setConcurrency("1-1");
        //factory.setMessageConverter(jacksonJmsMessageConverter());
        factory.setMessageConverter(xmlMarshalingMessageConverter());

        return factory;
    }

}