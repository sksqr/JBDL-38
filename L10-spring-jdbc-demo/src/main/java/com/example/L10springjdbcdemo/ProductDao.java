package com.example.L10springjdbcdemo;

import com.example.L10springjdbcdemo.dao.IProductDao;
import com.example.L10springjdbcdemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository("productDaoJdbcTemplate")
public class ProductDao implements IProductDao
{
    @Value("${getProductByName}")
    private String getProductByNameQuery;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RowMapper<Product> productRowMapper;

    @Override
    public List<Product> getProductsByName(String name){

        List<Product> list = new ArrayList<>();

        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,name);
            }
        };

       list = jdbcTemplate.query(getProductByNameQuery,preparedStatementSetter,productRowMapper);

        return list;
    }

    @Override
    public Product createProduct(Product product){
        String query = "insert into product values (NULL,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setDouble(2,product.getPrice());
            return ps;
        },keyHolder);
         product.setId(keyHolder.getKey().intValue());
         return product;
    }
}
