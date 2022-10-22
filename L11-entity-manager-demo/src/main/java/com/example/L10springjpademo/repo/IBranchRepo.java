package com.example.L10springjpademo.repo;

import com.example.L10springjpademo.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchRepo extends JpaRepository<Branch,Integer> {
}
