package com.wipro.kafkaproducer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;



public class Producer {
	public static void main(String[] args) {
		Properties props = new Properties();
		
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);


		KafkaProducer<String, StudentModel> producer = new KafkaProducer<String, StudentModel>(props);
		// logger.info("Producer is created.");
		StudentModel student = new StudentModel(4, "Mr.D");
		ProducerRecord<String, StudentModel> record = new ProducerRecord<String, StudentModel>("student-topic",student.getName(),student);

		producer.send(record);
		// logger.info("Record has been sent to Kafka...");
		
		producer.close();
		// logger.info("Producer is closed...");
	}
}
