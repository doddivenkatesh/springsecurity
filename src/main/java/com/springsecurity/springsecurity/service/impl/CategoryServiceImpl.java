//package com.springsecurity.springsecurity.service.impl;
//
//import com.springsecurity.springsecurity.document.exceptio.ResourceNotFoundException;
//import com.springsecurity.springsecurity.dto.CategoryDTO;
//import com.springsecurity.springsecurity.entity.Category;
//import com.springsecurity.springsecurity.mapper.CategoryMapper;
//import com.springsecurity.springsecurity.repo.CategoryRepository;
//import com.springsecurity.springsecurity.service.CategoryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class CategoryServiceImpl implements CategoryService {
//
//    private final CategoryRepository categoryRepository;
//    private final CategoryMapper categoryMapper;
//
//    @Override
//    public List<CategoryDTO> getAllCategories() {
//        return categoryRepository.findAll()
//                .stream()
//                .map(categoryMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public CategoryDTO getCategoryById(Long id) {
//        Category category = categoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
//        return categoryMapper.toDTO(category);
//    }
//
//    @Override
//    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
//        Category category = categoryMapper.toEntity(categoryDTO);
//        Category saved = categoryRepository.save(category);
//        return categoryMapper.toDTO(saved);
//    }
//
//    @Override
//    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
//        Category existing = categoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
//        existing.setName(categoryDTO.getName());
//        Category updated = categoryRepository.save(existing);
//        return categoryMapper.toDTO(updated);
//    }
//
//    @Override
//    public void deleteCategory(Long id) {
//        Category existing = categoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + id));
//        categoryRepository.delete(existing);
//    }
//}
