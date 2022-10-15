package com.example.L09jdbcdemo;

import com.example.L09jdbcdemo.models.Product;

import java.sql.*;

public class TrnasactionDemo {

    public static void main(String[] args) throws SQLException {
        boolean autoCommit = false;
        Connection con=null;
        try {
            Product product = new Product();
            product.setName("PenDrive");
            product.setPrice(100.00);
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_system", "app1", "Jbdl@1234");
            autoCommit = con.getAutoCommit();
            con.setAutoCommit(false);
            Statement stmt = con.createStatement();
            String query = "insert into product values (14,'"+product.getName()+"',"+product.getPrice()+")";
            stmt.execute(query);
            String selectQuery = "Select Max(id) from product";
            ResultSet resultSet = stmt.executeQuery(selectQuery);
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                System.out.println(id);
            }
            con.commit();
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        finally {
            con.setAutoCommit(autoCommit);
        }
    }
}
