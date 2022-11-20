package com.example.L20paymentgatewaydemo.repo;

import com.example.L20paymentgatewaydemo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Transaction findByTxnId(String txnId);
}
