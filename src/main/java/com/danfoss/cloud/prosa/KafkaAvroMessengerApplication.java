package com.danfoss.cloud.prosa;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class KafkaAvroMessengerApplication {

	@Value("${topic.name}")
	private String topicName;

	@Value("${topic.partitions-num}")
	private Integer partitions;

	@Value("${topic.replication-factor}")
	private short replicationFactor;


	@Bean
	NewTopic moviesTopic() {
		return new NewTopic(topicName, partitions, replicationFactor);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaAvroMessengerApplication.class, args);
	}

}
