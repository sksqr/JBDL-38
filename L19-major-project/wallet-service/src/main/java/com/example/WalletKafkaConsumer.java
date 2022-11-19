package com.example;


import com.example.entity.Wallet;
import com.example.repo.WalletRepo;
import com.example.service.WalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class WalletKafkaConsumer {
    private static Logger LOGGER = LoggerFactory.getLogger(WalletKafkaConsumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private WalletRepo walletRepo;

    @KafkaListener(topics = "USER_CREATED", groupId = "temp1")
    public void consumerUserCreated(Object message) throws JsonProcessingException {
        LOGGER.info("Consumed from kafka : {}",message);

//        Object value =((ConsumerRecord) message).value();
//        String stringValue = objectMapper.writeValueAsString(value);
//        Map<String,Object> map = objectMapper.convertValue(stringValue, HashMap.class);
//        objectMapper.convertValue(objectMapper.writeValueAsString(((ConsumerRecord) message).value()),HashMap.class);
//
//        Wallet wallet = Wallet.builder()
//                .balance(100.00)
//                .userId((Long) map.get("userId"))
//                .build();
//        walletRepo.save(wallet);
    }
}
