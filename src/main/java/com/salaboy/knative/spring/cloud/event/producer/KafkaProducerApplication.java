package com.salaboy.knative.spring.cloud.event.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.UUID;

@SpringBootApplication
@EnableBinding(MyChannels.class)
@EnableScheduling
public class KafkaProducerApplication {

    @Autowired
    private MessageChannel myProducer;

    public static void main(String[] args) {
        SpringApplication.run(KafkaProducerApplication.class, args);
    }

    @Scheduled(fixedDelay = 3000)
    public void sendMessageEveryX() {
		System.out.println("> Sending a message...");
        myProducer.send(MessageBuilder.withPayload("{\"name\":\"salaboy : " + UUID.randomUUID().toString() + " \"}").build());
    }


}


