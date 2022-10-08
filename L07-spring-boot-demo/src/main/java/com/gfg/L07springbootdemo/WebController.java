package com.gfg.L07springbootdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

    @GetMapping("/menu")
//    @ResponseBody
    public String getHello(){
        return "menu.html";
    }


}
