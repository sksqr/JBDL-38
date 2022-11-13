package com.example.L18filterloggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class HelloController {
//
//    @Autowired
//    private RestTemplate restTemplate;

    private static Logger LOGGER = LoggerFactory.getLogger(HelloController.class);


    @GetMapping("/hello")
    ResponseEntity<String> getHello(@RequestParam String username){
        LOGGER.info("Hello "+username);

        // set http headert while making http calls
        // restTemplate.

        return ResponseEntity.ok("Hello "+username);
    }



    @GetMapping("/app-health")
    ResponseEntity<String> getHEalth(){
        return ResponseEntity.ok("Done");
    }




}
