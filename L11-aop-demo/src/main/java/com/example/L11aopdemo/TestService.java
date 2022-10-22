package com.example.L11aopdemo;

import com.example.L11aopdemo.aop.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class TestService {

//    @LogExecutionTime
    public String getData() throws InterruptedException {
        Thread.sleep(10);
        return "Hello! from "+Thread.currentThread().getName();
    }
}
