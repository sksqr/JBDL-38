package com.example.L18kafkademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class HelloController {

    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    private static final String topic ="test-topic";

//    @Autowired
//    private KafkaTemplate<String,Product> kafkaTemplate;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    @GetMapping("/pushData")
    ResponseEntity<String> pushData(@RequestParam String data, @RequestParam String userId) throws ExecutionException, InterruptedException {

//        Product product = new Product();
//        product.setName("Laptop");
//        product.setOrderId("121342");
//        product.setPrice(1000000.00);

        ListenableFuture future =  kafkaTemplate.send(topic,userId,data);

        LOGGER.info("Push data to kafka : {}", future.get());

        return ResponseEntity.ok("Pushed the data");
    }
}
/*
welcomeUser1
welcomeUser2
reward1
reward2
============


welcomeUser1
welcomeUser2
reward2
reward1

=======

 */