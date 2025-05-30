//package com.springsecurity.springsecurity.service.impl;
//
//import com.springsecurity.springsecurity.document.exceptio.ResourceNotFoundException;
//import com.springsecurity.springsecurity.dto.CourseDTO;
//import com.springsecurity.springsecurity.entity.Category;
//import com.springsecurity.springsecurity.entity.Course;
//import com.springsecurity.springsecurity.entity.SubCategory;
//import com.springsecurity.springsecurity.mapper.CourseMapper;
//import com.springsecurity.springsecurity.repo.CategoryRepository;
//import com.springsecurity.springsecurity.repo.CourseRepository;
//import com.springsecurity.springsecurity.repo.SubCategoryRepository;
//import com.springsecurity.springsecurity.service.CourseService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class CourseServiceImpl implements CourseService {
//
//    private final CourseRepository courseRepository;
//    private final CategoryRepository categoryRepository;
//    private final SubCategoryRepository subCategoryRepository;
//    private final CourseMapper courseMapper;
//
//    @Override
//    public List<CourseDTO> getAllCourses() {
//        return courseRepository.findAll()
//                .stream()
//                .map(courseMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<CourseDTO> getCoursesByCategoryId(Long categoryId) {
//        return courseRepository.findByCategoryId(categoryId)
//                .stream()
//                .map(courseMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<CourseDTO> getCoursesBySubCategoryId(Long subCategoryId) {
//        return courseRepository.findBySubCategoryId(subCategoryId)
//                .stream()
//                .map(courseMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public CourseDTO getCourseById(Long id) {
//        Course course = courseRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
//        return courseMapper.toDTO(course);
//    }
//
//    @Override
//    public CourseDTO createCourse(CourseDTO courseDTO) {
//        Long categoryId = courseDTO.getCategoryId();
//        Long subCategoryId = courseDTO.getSubCategoryId();
//
//        Category category = categoryRepository.findById(categoryId)
//                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
//
//        SubCategory subCategory = subCategoryRepository.findById(subCategoryId)
//                .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id " + subCategoryId));
//
//        Course course = courseMapper.toEntity(courseDTO);
//        course.setCategory(category);
//        course.setSubCategory(subCategory);
//
//        Course saved = courseRepository.save(course);
//        return courseMapper.toDTO(saved);
//    }
//
//    @Override
//    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
//        Course existing = courseRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
//
//        existing.setTitle(courseDTO.getTitle());
//        existing.setDescription(courseDTO.getDescription());
//        existing.setPrice(courseDTO.getPrice());
//        existing.setReleaseDate(courseDTO.getReleaseDate());
//        existing.setAvailable(courseDTO.isAvailable());
//
//        if (!existing.getCategory().getId().equals(courseDTO.getCategoryId())) {
//            Category category = categoryRepository.findById(courseDTO.getCategoryId())
//                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + courseDTO.getCategoryId()));
//            existing.setCategory(category);
//        }
//
//        if (!existing.getSubCategory().getId().equals(courseDTO.getSubCategoryId())) {
//            SubCategory subCategory = subCategoryRepository.findById(courseDTO.getSubCategoryId())
//                    .orElseThrow(() -> new ResourceNotFoundException("SubCategory not found with id " + courseDTO.getSubCategoryId()));
//            existing.setSubCategory(subCategory);
//        }
//
//        Course updated = courseRepository.save(existing);
//        return courseMapper.toDTO(updated);
//    }
//
//    @Override
//    public void deleteCourse(Long id) {
//        Course existing = courseRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
//        courseRepository.delete(existing);
//    }
//}
