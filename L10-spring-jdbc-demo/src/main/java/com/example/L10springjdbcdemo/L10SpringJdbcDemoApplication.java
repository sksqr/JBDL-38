package com.example.L10springjdbcdemo;

import com.example.L10springjdbcdemo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class L10SpringJdbcDemoApplication {

	@Autowired
	private DataSource dataSource;


//	@Bean
//	public DataSource mysqlDataSource() {
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/demo_system");
//		dataSource.setUsername("app1");
//		dataSource.setPassword("Jbdl@1234");
//		return dataSource;
//	}

	@Bean
	public JdbcTemplate jdbcTemplate(){
		return new JdbcTemplate(dataSource);
	}

	@Bean
	public RowMapper<Product> productRowMapper(){
		RowMapper<Product> productRowMapper = new RowMapper<Product>() {
			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				return product;
			}
		};
		return productRowMapper;
	}

	@Bean
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(){
		return new NamedParameterJdbcTemplate(jdbcTemplate());
	}





	public static void main(String[] args) {
		SpringApplication.run(L10SpringJdbcDemoApplication.class, args);
	}

}
