//package com.springsecurity.springsecurity.service.impl;
//
//import com.springsecurity.springsecurity.document.exceptio.ResourceNotFoundException;
//import com.springsecurity.springsecurity.dto.SubCategoryDTO;
//import com.springsecurity.springsecurity.entity.Category;
//import com.springsecurity.springsecurity.entity.SubCategory;
//import com.springsecurity.springsecurity.mapper.SubCategoryMapper;
//import com.springsecurity.springsecurity.repo.CategoryRepository;
//import com.springsecurity.springsecurity.repo.SubCategoryRepository;
//import com.springsecurity.springsecurity.service.SubCategoryService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class SubCategoryServiceImpl implements SubCategoryService {
//
//    private final SubCategoryRepository subCategoryRepository;
//    private final CategoryRepository categoryRepository;
//    private final SubCategoryMapper subCategoryMapper;
//
//    @Override
//    public List<SubCategoryDTO> getAllSubCategories() {
//        return subCategoryRepository.findAll()
//                .stream()
//                .map(subCategoryMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<SubCategoryDTO> getSubCategoriesByCategoryId(Long categoryId) {
//        return subCategoryRepository.findByCategoryId(categoryId)
//                .stream()
//                .map(subCategoryMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public SubCategoryDTO getSubCategoryById(Long id) {
//        SubCategory subCategory = subCategoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id " + id));
//        return subCategoryMapper.toDTO(subCategory);
//    }
//
//    @Override
//    public SubCategoryDTO createSubCategory(SubCategoryDTO subCategoryDTO) {
//        Long categoryId = subCategoryDTO.getCategoryId();
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
//        
//        SubCategory subCategory = subCategoryMapper.toEntity(subCategoryDTO);
//        subCategory.setCategory(category);
//        SubCategory saved = subCategoryRepository.save(subCategory);
//        return subCategoryMapper.toDTO(saved);
//    }
//
//    @Override
//    public SubCategoryDTO updateSubCategory(Long id, SubCategoryDTO subCategoryDTO) {
//        SubCategory existing = subCategoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id " + id));
//        
//        existing.setName(subCategoryDTO.getName());
//        
//        if (!existing.getCategory().getId().equals(subCategoryDTO.getCategoryId())) {
//            Category category = categoryRepository.findById(subCategoryDTO.getCategoryId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + subCategoryDTO.getCategoryId()));
//            existing.setCategory(category);
//        }
//        
//        SubCategory updated = subCategoryRepository.save(existing);
//        return subCategoryMapper.toDTO(updated);
//    }
//
//    @Override
//    public void deleteSubCategory(Long id) {
//        SubCategory existing = subCategoryRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id " + id));
//        subCategoryRepository.delete(existing);
//    }
//}
