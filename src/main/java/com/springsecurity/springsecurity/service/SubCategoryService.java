package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.entity.SubCategory;
import com.springsecurity.springsecurity.repo.SubCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    public SubCategoryService(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    public Optional<SubCategory> getSubCategoryById(Long id) {
        return subCategoryRepository.findById(id);
    }

    public List<SubCategory> getSubCategoriesByCategoryId(Long categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }

    public SubCategory saveSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }

    public boolean existsByName(String name) {
        return subCategoryRepository.existsByName(name);
    }
}
