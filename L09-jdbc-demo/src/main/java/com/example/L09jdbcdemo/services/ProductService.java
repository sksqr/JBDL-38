package com.example.L09jdbcdemo.services;


import com.example.L09jdbcdemo.ProductDao;
import com.example.L09jdbcdemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;


    public Product addProduct(Product product){
        return productDao.createProduct(product);
    }

    public List<Product> getProducts(){

        return null;
    }

    public List<Product> getProductsByName(String name){

        return productDao.getProductsByName(name);
    }


    public Product getProductById(Integer id){

        return null;
    }
}
