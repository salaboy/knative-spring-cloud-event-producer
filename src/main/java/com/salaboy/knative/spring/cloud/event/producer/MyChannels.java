package com.salaboy.knative.spring.cloud.event.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyChannels {
    String MY_PRODUCER = "myProducer";

    @Output(MY_PRODUCER)
    MessageChannel myProducer();
}
