package com.springreboot.kafka.pubsub.event.subscriber;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EventSubscriber {

	@KafkaListener(id = "consumer.group.1", topics = "${springreboot.pubsub.kafka.topic}")
	public void listen(ConsumerRecord<String, String> record) {
		System.out.println(record);
	}

}
