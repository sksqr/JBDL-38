package com.example.L10springjpademo.repo;

import com.example.L10springjpademo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee,Integer> {

}
