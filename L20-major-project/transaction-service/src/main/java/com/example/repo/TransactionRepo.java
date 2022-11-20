package com.example.repo;

import com.example.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    Transaction findByTxnId(String txnId);
}
