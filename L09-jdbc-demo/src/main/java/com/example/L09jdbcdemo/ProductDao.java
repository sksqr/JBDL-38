package com.example.L09jdbcdemo;

import com.example.L09jdbcdemo.models.Product;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDao {


    public List<Product> getProductsByName(String name){

        Connection con = null;
        List<Product> list = new ArrayList<>();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "app1", "Jbdl@1234");
            String query = "select * from product where name LIKE ? ";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setName(resultSet.getString(2));
                product.setPrice(resultSet.getDouble(3));
                list.add(product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
    public Product createProduct(Product product){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "app1", "Jbdl@1234");
            String query = "insert into product values (NULL,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2,product.getPrice());

            preparedStatement.execute();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                product.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return product;
    }

    private Product createWithStatement(Product product){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "app1", "Jbdl@1234");
            Statement stmt = con.createStatement();
            String query = "insert into product values (NULL,'"+product.getName()+"',"+product.getPrice()+")";
            stmt.execute(query);

            String selectQuery = "Select Max(id) from product";
            ResultSet resultSet = stmt.executeQuery(selectQuery);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println(id);
                product.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    public static void main(String[] args) {
        try {
            Product product = new Product();
            product.setName("Pen");
            product.setPrice(3000.00);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "app1", "Jbdl@1234");
            Statement stmt = con.createStatement();
            String query = "insert into product values (NULL,'"+product.getName()+"',"+product.getPrice()+")";
            stmt.execute(query);

            String selectQuery = "Select Max(id) from product";
            ResultSet resultSet = stmt.executeQuery(selectQuery);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
