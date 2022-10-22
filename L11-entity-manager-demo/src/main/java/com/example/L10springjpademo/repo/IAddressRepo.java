package com.example.L10springjpademo.repo;

import com.example.L10springjpademo.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepo extends JpaRepository<Address,Integer> {
}
