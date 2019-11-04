package com.springreboot.kafka.pubsub.event.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

@Component
public class EventPublisher {

	@Autowired
	KafkaTemplate<Object, Object> template;
	
	@Value(value = "${springreboot.pubsub.kafka.topic}")
	String topicName;
	
	public void publish(String message) {
		ListenableFuture<SendResult<Object, Object>> future = this.template.send(topicName, message);
		 future.addCallback(new SuccessCallback<SendResult<Object, Object>>() {
			
			@Override
			public void onSuccess(SendResult<Object, Object> result) {
				System.out.println(result); 
			}
		}, new FailureCallback() {
			
			@Override
			public void onFailure(Throwable ex) {
				ex.printStackTrace();
			}
		});
	}
}
