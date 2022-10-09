package com.example.L08springbootmvcannotations.controllers;

import com.example.L08springbootmvcannotations.models.Product;
import com.example.L08springbootmvcannotations.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class WebController {


    private ProductService productService;

    public WebController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/menu")
    public ModelAndView getMenu(){
        ModelAndView modelAndView = new ModelAndView("dynamic-menu.html");
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY hh:mm:ss");
        modelAndView.getModelMap().put("serverTime",dateFormat.format(new Date()));
        modelAndView.getModelMap().put("products",productService.getProducts());
        return modelAndView;

    }


    @GetMapping("/productList")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getProducts();
    }
}
