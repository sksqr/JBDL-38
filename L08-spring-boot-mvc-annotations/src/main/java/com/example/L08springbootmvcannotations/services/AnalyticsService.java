package com.example.L08springbootmvcannotations.services;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class AnalyticsService {

    public AnalyticsService() {
        // connect with analytical server : throw RunTimeException
    }

    @PostConstruct
    public void init(){

    }
    public void pushForAnalysis(String data){
        //
    }
}
