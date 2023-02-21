package com.asb.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class KafkaConsumerController {

	@Autowired
	private Gson gson;

//	@KafkaListener(topics = { "my-topic" })
//	@KafkaListener(topics = { "topic-slack" })
	@KafkaListener(topics = { "categoria_connector_mysql" })
	public void getTopics(@RequestBody String emp) {
		System.out.println("Kafka event consumed is: " + emp);
		Message model = gson.fromJson(emp, Message.class);
		System.out.println("Model converted value: " + model.toString());
	}
}