package com.springsecurity.springsecurity.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveProduct(Product product) {
		String sql = "INSERT INTO TABLE PRODUCT VALUES (?,?)";
		Object[] args = {product.getId(),product.getName()};
		jdbcTemplate.update(sql,args);
	}
}
