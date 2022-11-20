package com.example;

import com.example.entity.Transaction;
import com.example.kafka.TransactionPayload;
import com.example.repo.TransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@Configuration
public class TransactionCompConsumer {

    private static Logger LOGGER  = LoggerFactory.getLogger(TransactionCompConsumer.class);

    @Autowired
    private TransactionRepo transactionRepo;

    @KafkaListener(topics = "TXN_COMP", groupId = "transaction-service", containerFactory = "txnCompKafkaListenerContainerFactory")
    public void consumeFromTxnComp(TransactionPayload payload){
        LOGGER.info("Consuming payload: {}",payload);
        String txnId = payload.getTxnId();
        Transaction transaction = transactionRepo.findByTxnId(txnId);
        if(TransactionStatus.SUCCESS.name().equals(payload.getStatus())){
            transaction.setStatus(TransactionStatus.SUCCESS);
        }
        else{
            transaction.setStatus(TransactionStatus.FAILED);
        }
        transactionRepo.save(transaction);
    }

}
