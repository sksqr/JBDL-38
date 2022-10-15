package com.example.L09springjdbcdemo;

import com.example.L09springjdbcdemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Product> getProductsByName(String name){

        Connection con = null;
        List<Product> list = new ArrayList<>();


        return list;
    }
    public Product createProduct(Product product){
        String query = "insert into product values (NULL,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query);
            ps.setString(1, product.getName());
            ps.setDouble(2,product.getPrice());
            return ps;
        },keyHolder);
         product.setId((Integer) keyHolder.getKey());
         return product;
    }
}
