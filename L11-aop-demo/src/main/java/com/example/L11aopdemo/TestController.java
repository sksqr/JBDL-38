package com.example.L11aopdemo;

import com.example.L11aopdemo.aop.LogExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;

    @GetMapping("/hello")
//    @LogExecutionTime
    public ResponseEntity<String> getData() throws InterruptedException {
//        long start = System.currentTimeMillis();
        String result = testService.getData();
//        long end = System.currentTimeMillis();
//        long total = end-start;
//        logger.info("Execution time:{}",total);
        return ResponseEntity.ok(result);
    }
}
