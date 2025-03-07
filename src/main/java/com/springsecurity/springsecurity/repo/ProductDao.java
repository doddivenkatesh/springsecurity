package com.springsecurity.springsecurity.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springsecurity.springsecurity.document.entity.ProductEntity;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Repository("productDao")
public interface ProductDao extends JpaRepository<ProductEntity, Long> {
	//List<ProductEntity> findByCategory(String category);

	//List<ProductEntity> findByAvailableTrue(Sort by);

	//List<ProductEntity> findByReleaseDateAfter(LocalDate date);
}
