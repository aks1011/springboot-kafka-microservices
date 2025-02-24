package com.devalok.microservice.emailservice.kafka;

import com.devalok.microservice.basedomains.dto.OrderEvent;
import com.devalok.microservice.basedomains.model.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

//  @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    @KafkaListener(topics = Constants.ORDER_TOPIC, groupId = Constants.EMAIL)
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order event received in Email Service. %s", event.toString()));

        // send an email to the customer
    }
}
