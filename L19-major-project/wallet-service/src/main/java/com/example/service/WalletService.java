package com.example.service;

import com.example.entity.Wallet;
import com.example.repo.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    private WalletRepo walletRepo;

    public Double getBalanceByUserId(Long userId){
        Wallet wallet = walletRepo.findByUserId(userId);
        return wallet.getBalance();
    }
}
