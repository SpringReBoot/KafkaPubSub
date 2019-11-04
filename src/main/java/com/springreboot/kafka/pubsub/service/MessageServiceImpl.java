package com.springreboot.kafka.pubsub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreboot.kafka.pubsub.event.publisher.EventPublisher;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	EventPublisher publisher;

	
	@Override
	public void publishMessage(String message) {
		publisher.publish(message); 		 
	}

}
