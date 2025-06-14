package com.springsecurity.springsecurity.controller;

import com.springsecurity.springsecurity.entity.Course;
import com.springsecurity.springsecurity.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Get all courses
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // Get course by ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get courses by category ID (non-paginated)
    @GetMapping("/by-category/{categoryId}")
    public List<Course> getCoursesByCategoryId(@PathVariable Long categoryId) {
        return courseService.getCoursesByCategoryId(categoryId);
    }

    // Get courses by category ID with pagination (page & size params)
    @GetMapping("/by-category/{categoryId}/page")
    public Page<Course> getCoursesByCategoryIdPage(
            @PathVariable Long categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return courseService.getCoursesByCategoryId(categoryId, PageRequest.of(page, size));
    }

    // Get courses by subcategory ID
    @GetMapping("/by-subcategory/{subCategoryId}")
    public List<Course> getCoursesBySubCategoryId(@PathVariable Long subCategoryId) {
        return courseService.getCoursesBySubCategoryId(subCategoryId);
    }

    // Get all available courses
    @GetMapping("/available")
    public List<Course> getAvailableCourses() {
        return courseService.getAvailableCourses();
    }

    // Create new course
    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    // Update course
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        return courseService.getCourseById(id).map(course -> {
            course.setTitle(courseDetails.getTitle());
            course.setDescription(courseDetails.getDescription());
            course.setPrice(courseDetails.getPrice());
            course.setReleaseDate(courseDetails.getReleaseDate());
            course.setAvailable(courseDetails.isAvailable());
            course.setCategory(courseDetails.getCategory());
            course.setSubCategory(courseDetails.getSubCategory());
            Course updated = courseService.saveCourse(course);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Delete course
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        if (courseService.getCourseById(id).isPresent()) {
            courseService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
