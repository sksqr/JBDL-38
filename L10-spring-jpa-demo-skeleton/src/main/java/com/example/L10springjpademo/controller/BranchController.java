package com.example.L10springjpademo.controller;


import com.example.L10springjpademo.entity.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
public class BranchController {


    @GetMapping("/{id}")
    public ResponseEntity<Branch> getBranchbyId(@PathVariable Integer id){
      return null;
    }
}
