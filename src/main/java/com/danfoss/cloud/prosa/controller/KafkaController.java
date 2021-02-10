package com.danfoss.cloud.prosa.controller;

import com.danfoss.cloud.prosa.avro.pojo.Alarm;
import com.danfoss.cloud.prosa.producer.Producer;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/alarm")
public class KafkaController {

    private final Producer producer;

    @Autowired
    private KafkaController(Producer producer) {
        this.producer = producer;
    }

    @Scheduled(fixedRateString = "${send.kafka.message}" )
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic() {
                com.danfoss.cloud.prosa.avro.pojo.Alarm alarm = new Alarm();
        this.producer.sendMessage(alarm);
    }
}
