package com.danfoss.cloud.prosa.consumer;

import com.danfoss.cloud.prosa.avro.pojo.Alarm;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@CommonsLog(topic = "Consumer Logger")
public class Consumer {

    @KafkaListener(topics = "#{'${topic.name}'.split(',')}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Alarm> record) {
        log.info(String.format("Consumed message -> %s", record));
    }
}
