package com.springsecurity.springsecurity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private LocalDate releaseDate;
    private boolean available;

    private Long categoryId;
    private String categoryName;

    private Long subCategoryId;
    private String subCategoryName;
}
