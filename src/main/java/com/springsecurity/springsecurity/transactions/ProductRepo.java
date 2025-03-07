package com.springsecurity.springsecurity.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void saveProduct(Productsss product) {
		// Correct SQL statement
		String sql = "INSERT INTO PRODUCT (id, name) VALUES (?, ?)";

		// Using object array for query parameters
		Object[] args = { product.getId(), product.getName() };

		// Execute the query
		jdbcTemplate.update(sql, args);
	}
}
