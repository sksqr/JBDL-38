package com.example.L09jdbcdemo.controllers;

import com.example.L09jdbcdemo.models.Product;
import com.example.L09jdbcdemo.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    private static Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProduct(){
        logger.info("Get Request for product");
        return productService.getProducts();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
         product = productService.addProduct(product);
         return ResponseEntity.ok(product);
    }

    @GetMapping("/byname")
    public List<Product> getProductByName(@RequestParam(value = "keyword") String keyword){
        logger.info("Received Keyword {}",keyword);
        return productService.getProductsByName(keyword);
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(value = "id") Integer id){
        return productService.getProductById(id);
    }


}
