package com.gfg.L07springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class GFGController {

    @GetMapping("/hello")
    public String getHello(){
        return "Hello by "+Thread.currentThread().getName();
    }


    @GetMapping("/time")
    public String getTime(){
        Date date = new Date();
        return  date.toString();
    }
}


