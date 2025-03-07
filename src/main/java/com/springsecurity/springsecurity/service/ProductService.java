package com.springsecurity.springsecurity.service;

import java.util.List;

import com.springsecurity.springsecurity.document.entity.ProductEntity;

public interface ProductService {
	public ProductEntity save(ProductEntity productEntity);

	public ProductEntity getByProductId(Long id);

	public List<ProductEntity> getAllProducts();

	ProductEntity updateProduct(Long id, ProductEntity updateProduct);

	public String deleteProduct(Long id);

	
}
