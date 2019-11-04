package com.springreboot.kafka.pubsub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreboot.kafka.pubsub.service.MessageService;

@CrossOrigin
@RestController
@RequestMapping(path = "/springreboot/pubsub")
public class APIController {

	@Autowired
	MessageService ms;
	
	//Don't worry about this being GET. This is just for demo
	@GetMapping(path = "/v1/messages/{message}")
	public void publishMessage(@PathVariable String message ) {
		ms.publishMessage(message);
	}
}
