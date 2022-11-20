package com.example;

import com.example.kafka.UserCreatedPayload;
import com.example.kafka.WalletUpdatePayload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@EnableKafka
@Configuration
public class NotificationKafkaConsumer {

    private static Logger LOGGER = LoggerFactory.getLogger(NotificationKafkaConsumer.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @KafkaListener(topics = "WALLET_UPDATE", groupId = "notification-service", containerFactory = "walletKafkaListenerContainerFactory")
    public void consumeFromWalletUpdate(WalletUpdatePayload payload){
        MDC.clear();
        MDC.put("requestId",payload.getRequestId());
        LOGGER.info("Consuming data from WALLET_UPDATE : {}",payload);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject("Wallet Update!!");
        simpleMailMessage.setTo(payload.getEmail());
        simpleMailMessage.setText("Your updated balance is Rs:"+payload.getBalance());
        javaMailSender.send(simpleMailMessage);
        LOGGER.info("Send email to : {}",payload.getEmail());
    }


    @KafkaListener(topics = "USER_CREATED", groupId = "notification-service", containerFactory = "userKafkaListenerContainerFactory")
    public void consumeFromUserCreated(UserCreatedPayload payload){
        MDC.clear();
        MDC.put("requestId",payload.getRequestId());
        LOGGER.info("Consuming data from USER_CREATED : {}",payload);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject("Welcome in JBDL-Wallet Family");
        simpleMailMessage.setTo(payload.getEmail());
        simpleMailMessage.setText("Hello! "+payload.getName()+" your account is ready.");
        javaMailSender.send(simpleMailMessage);
        LOGGER.info("Send email to : {}",payload.getEmail());
    }

}
