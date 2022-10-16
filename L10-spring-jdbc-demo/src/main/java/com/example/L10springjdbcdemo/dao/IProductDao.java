package com.example.L10springjdbcdemo.dao;

import com.example.L10springjdbcdemo.models.Product;

import java.util.List;

public interface IProductDao {


    public List<Product> getProductsByName(String name);


    public Product createProduct(Product product);


}
