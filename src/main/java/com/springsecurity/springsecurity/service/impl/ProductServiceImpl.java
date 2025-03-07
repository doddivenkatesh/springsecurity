package com.springsecurity.springsecurity.service.impl;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springsecurity.springsecurity.document.entity.ProductEntity;
import com.springsecurity.springsecurity.document.exceptio.ProductNotFoundException;
import com.springsecurity.springsecurity.repo.ProductDao;
import com.springsecurity.springsecurity.service.ProductService;

import ch.qos.logback.classic.Logger;
import jakarta.annotation.Resource;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	Logger logger = (Logger) LoggerFactory.getLogger(ProductServiceImpl.class);

	@Resource(name = "productDao")
	private ProductDao productDao;

	@Override
	public ProductEntity save(ProductEntity productEntity) {
		return productDao.save(productEntity);
	}

	@Override
	@Cacheable(cacheNames = "products", key = "#id")
	public ProductEntity getByProductId(Long id) {
		logger.info("Getting Product by ID from db");
		return productDao.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Product not found for the given id: " + id));
	}

	@Override
	public List<ProductEntity> getAllProducts() {
		logger.info("Getting all products from db");
		return productDao.findAll();
	}

	@Override
	public ProductEntity updateProduct(Long id, ProductEntity updateProduct) {
		logger.info("Updating Product for id: " + id);

		return productDao.findById(id).map(product -> {
			product.setName(updateProduct.getName());
			product.setCategory(updateProduct.getCategory());
			product.setPrice(updateProduct.getPrice());
			product.setAvailable(updateProduct.isAvailable());
			product.setReleaseDate(updateProduct.getReleaseDate());

			return productDao.save(product);
		}).orElseThrow(() -> new ProductNotFoundException("Product not found for the given id: " + id));
	}

	@Override
	public String deleteProduct(Long id) {
		return productDao.findById(id).map(product -> {
			productDao.deleteById(id);
			return "Product successfully deleted";
		}).orElseThrow(() -> new ProductNotFoundException("Product ID not found"));
	}

}
