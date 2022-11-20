package com.example.repo;

import com.example.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepo extends JpaRepository<Wallet,Long> {

    Wallet findByUserId(Long userId);

}
