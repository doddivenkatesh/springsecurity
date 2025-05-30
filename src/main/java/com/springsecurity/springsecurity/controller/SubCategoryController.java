package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.entity.SubCategory;
import com.springsecurity.springsecurity.service.SubCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subcategories")
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    // Get all subcategories
    @GetMapping
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    // Get subcategory by ID
    @GetMapping("/{id}")
    public ResponseEntity<SubCategory> getSubCategoryById(@PathVariable Long id) {
        return subCategoryService.getSubCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get subcategories by category ID
    @GetMapping("/by-category/{categoryId}")
    public List<SubCategory> getSubCategoriesByCategoryId(@PathVariable Long categoryId) {
        return subCategoryService.getSubCategoriesByCategoryId(categoryId);
    }

    // Create new subcategory
    @PostMapping
    public SubCategory createSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.saveSubCategory(subCategory);
    }

    // Update existing subcategory
    @PutMapping("/{id}")
    public ResponseEntity<SubCategory> updateSubCategory(@PathVariable Long id, @RequestBody SubCategory subCategoryDetails) {
        return subCategoryService.getSubCategoryById(id).map(subCategory -> {
            subCategory.setName(subCategoryDetails.getName());
            subCategory.setCategory(subCategoryDetails.getCategory());
            SubCategory updated = subCategoryService.saveSubCategory(subCategory);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete subcategory
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubCategory(@PathVariable Long id) {
        if (subCategoryService.getSubCategoryById(id).isPresent()) {
            subCategoryService.deleteSubCategory(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
