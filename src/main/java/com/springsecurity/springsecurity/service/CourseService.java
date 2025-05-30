package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.entity.Course;
import com.springsecurity.springsecurity.repo.CourseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> getCoursesByCategoryId(Long categoryId) {
        return courseRepository.findByCategoryId(categoryId);
    }

    public Page<Course> getCoursesByCategoryId(Long categoryId, Pageable pageable) {
        return courseRepository.findByCategoryId(categoryId, pageable);
    }

    public List<Course> getCoursesBySubCategoryId(Long subCategoryId) {
        return courseRepository.findBySubCategoryId(subCategoryId);
    }

    public List<Course> getAvailableCourses() {
        return courseRepository.findByAvailableTrue();
    }

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
