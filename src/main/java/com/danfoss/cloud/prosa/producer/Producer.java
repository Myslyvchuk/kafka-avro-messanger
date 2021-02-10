package com.danfoss.cloud.prosa.producer;

import com.danfoss.cloud.prosa.avro.Alarm;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Producer Logger")
public class Producer {

    @Value("${topic.name}")
    private String TOPIC;

    private final KafkaTemplate<String, Alarm> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, Alarm> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(com.danfoss.cloud.prosa.avro.pojo.Alarm alarm) {
        this.kafkaTemplate.send(this.TOPIC, alarm.toAvro());
        log.info(String.format("Produced alarm -> %s", alarm));
    }
}