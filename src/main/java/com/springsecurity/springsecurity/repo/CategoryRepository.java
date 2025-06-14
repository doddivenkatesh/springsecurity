package com.springsecurity.springsecurity.repo;

import com.springsecurity.springsecurity.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByName(String name);
    List<Category> findByNameContainingIgnoreCase(String namePart);
}
