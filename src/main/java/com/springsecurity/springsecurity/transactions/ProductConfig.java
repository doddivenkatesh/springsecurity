package com.springsecurity.springsecurity.transactions;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jakarta.activation.DataSource;

@Configuration
@ComponentScan("com")
public class ProductConfig {

	/*@Bean
	public DataSource dataSource() {
		return (DataSource) new DriverManagerDataSource("jdbc:mysql://127.0.0.1:3306/first.product", "root", "NBS@123nbs");
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate((javax.sql.DataSource) dataSource());
	}*/
}
