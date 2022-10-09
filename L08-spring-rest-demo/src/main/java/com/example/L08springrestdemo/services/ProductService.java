package com.example.L08springrestdemo.services;


import com.example.L08springrestdemo.models.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    static int nextId=1;

    static List<Product> productList;

    @PostConstruct
    public void initProduct(){
        productList=new ArrayList<>();
        productList.add(new Product("laptop",3000.00));
        productList.add(new Product("mobile",30.00));
        productList.add(new Product("pen drive",30.00));
    }


    public Product addProduct(Product product){
        product.setId(nextId);
        nextId++;
        productList.add(product);
        return product;
    }

    public boolean updateProduct(Integer id, Product newproduct){
        boolean exist =false;
        for(Product product:productList){
            if(id.equals(product.getId())){
                product.setName(newproduct.getName());
                product.setPrice(newproduct.getPrice());
                exist = true;
                break;
            }
        }
       return exist;
    }


    public boolean deleteProduct(Integer id){
        boolean exist =false;
        for(Product product:productList){
            if(id.equals(product.getId())){
                productList.remove(product);
                exist = true;
                break;
            }
        }
        return exist;
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
