package com.example.L10springjdbcdemo.dao;

import com.example.L10springjdbcdemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository("productNamedDao")
public class ProductNamedDao implements IProductDao{

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;



    @Autowired
    private RowMapper<Product> productRowMapper;

    @Override
    public List<Product> getProductsByName(String name){

        List<Product> list = new ArrayList<>();
        String query = "select * from product where name=:name";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("name",name);

        list = namedParameterJdbcTemplate.query(query,parameterSource,productRowMapper);

        return list;
    }

    @Override
    public Product createProduct(Product product){
        String query = "insert into product values (NULL,:name,:price)";

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("name",product.getName());
        parameterSource.addValue("price",product.getPrice());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(query,parameterSource,keyHolder);
        product.setId(keyHolder.getKey().intValue());
        return product;
    }

}
