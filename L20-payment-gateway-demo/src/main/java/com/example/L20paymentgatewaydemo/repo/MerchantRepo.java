package com.example.L20paymentgatewaydemo.repo;

import com.example.L20paymentgatewaydemo.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepo extends JpaRepository<Merchant, Long> {
}
