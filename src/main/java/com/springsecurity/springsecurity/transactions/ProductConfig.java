package com.springsecurity.springsecurity.transactions;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com")
public class ProductConfig {

	@Bean
	public DataSource dataSource() {
		return  new DriverManagerDataSource("jdbc:mysql://127.0.0.1:3306/first", "root", "NBS@123nbs");
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate((javax.sql.DataSource) dataSource());
	}
}
