package com.example.L10springjdbcdemo.services;

import com.example.L10springjdbcdemo.ProductDao;
import com.example.L10springjdbcdemo.dao.IProductDao;
import com.example.L10springjdbcdemo.dao.ProductNamedDao;
import com.example.L10springjdbcdemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    @Qualifier("productNamedDao")
    private IProductDao productDao;


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
