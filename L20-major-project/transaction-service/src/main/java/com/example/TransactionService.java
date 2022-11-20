package com.example;

import com.example.dto.TransactionRequest;
import com.example.entity.Transaction;
import com.example.kafka.TransactionPayload;
import com.example.repo.TransactionRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class TransactionService {

    private static String TOPIC = "TXN_INIT";

    private static Logger LOGGER = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepo transactionRepo;

    @Autowired
    private KafkaTemplate<String, TransactionPayload> kafkaTemplate;

    public String getStatus(String txnId){
        Transaction transaction = transactionRepo.findByTxnId(txnId);
        return transaction.getStatus().name();
    }

    public String initTransaction(TransactionRequest request) throws ExecutionException, InterruptedException {
        String txnId = UUID.randomUUID().toString();
        Transaction transaction = Transaction.builder()
                .fromUserId(request.getFromUserId())
                .toUserId(request.getToUserId())
                .amount(request.getAmount())
                .status(TransactionStatus.PENDING)
                .txnId(txnId)
                .build();
        transactionRepo.save(transaction);

        TransactionPayload transactionPayload = TransactionPayload.builder()
                .fromUserId(request.getFromUserId())
                .toUserId(request.getToUserId())
                .amount(request.getAmount())
                .status(TransactionStatus.PENDING.toString())
                .txnId(txnId)
                .reason(request.getRemark())
                .build();

        ListenableFuture listenableFuture = kafkaTemplate.send(TOPIC,transactionPayload);

        LOGGER.info("Pushed to:{}  kafka response: {}",TOPIC,listenableFuture.get());

        return txnId;
    }
}
