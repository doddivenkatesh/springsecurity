package com.springsecurity.springsecurity.repo;

import com.springsecurity.springsecurity.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCategoryId(Long categoryId);
    List<Course> findBySubCategoryId(Long subCategoryId);
    List<Course> findByAvailableTrue();
    Page<Course> findByCategoryId(Long categoryId, Pageable pageable);
}
