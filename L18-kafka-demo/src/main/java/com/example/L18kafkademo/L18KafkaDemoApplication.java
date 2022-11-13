package com.example.L18kafkademo;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteBufferDeserializer;
import org.apache.kafka.common.serialization.BytesSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class L18KafkaDemoApplication {

//	@Bean
//	public ProducerFactory getProducerFactory(){
//		Map<String,Object> configProp = new HashMap<>();
//		configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
//		configProp.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
////		configProp.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, BytesSerializer.class);
//		return new DefaultKafkaProducerFactory<String,Product>(configProp);
//	}
//
//	@Bean
//	public KafkaTemplate<String,Product> getKafkaTemplate(){
//		return new KafkaTemplate<>(getProducerFactory());
//	}

	public static void main(String[] args) {
		SpringApplication.run(L18KafkaDemoApplication.class, args);
	}

}
