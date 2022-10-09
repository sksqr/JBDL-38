package com.example.L08springbootmvcannotations.controllers;

import com.example.L08springbootmvcannotations.models.Product;
import com.example.L08springbootmvcannotations.services.AnalyticsService;
import com.example.L08springbootmvcannotations.services.ProductService;
import org.jbdl38.KeywordAnalyser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private static Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private ProductService productService;

    @Autowired(required = false)
    private AnalyticsService analyticsService;

    @Autowired
//    @Qualifier("uniqueKeywordAnalyser")
    private KeywordAnalyser keywordAnalyser;

    @GetMapping
    public List<Product> getProduct(){
        logger.info("Get Request for product");
        return productService.getProducts();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
         productService.addProduct(product);
    }

    @GetMapping("/byname")
    public List<Product> getProductByName(@RequestParam(value = "keyword") String keyword){
        logger.info("Received Keyword {}",keyword);
        if(analyticsService != null){
            analyticsService.pushForAnalysis(keyword);
        }
        keywordAnalyser.recordKeyword(keyword);
        return productService.getProductsByName(keyword);
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer id){
        return productService.getProductById(id);
    }


    @GetMapping("/menu")
    public String getMenu(){
        return "menu.html";
    }


    @GetMapping("/keywords")
    public List<String> getAllKeyword(){
        return keywordAnalyser.getAllKeywords();
    }


}
