package com.example.L08springbootmvcannotations.services;


import com.example.L08springbootmvcannotations.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Value("${initial.keyword}")
    private String initialKeyword;


    static int nextId=1;

    static List<Product> productList;

    @PostConstruct
    public void initProduct(){
        productList=new ArrayList<>();
        productList.add(new Product("laptop",3000.00));
        productList.add(new Product("mobile",30.00));
        productList.add(new Product("pen drive",30.00));
    }


    public void addProduct(Product product){
        product.setId(nextId);
        nextId++;
        productList.add(product);
    }

    public List<Product> getProducts(){
        return productList;
    }

    public List<Product> getProductsByName(String name){
        List<Product> result = new ArrayList<>();
        for(Product product:productList){
            if(name.equals(product.getName())){
                result.add(product);
            }
        }
        return result;
    }


    public Product getProductById(Integer id){

        for(Product product:productList){
            if(id.equals(product.getId())){
                return product;
            }
        }
        return null;
    }
}
