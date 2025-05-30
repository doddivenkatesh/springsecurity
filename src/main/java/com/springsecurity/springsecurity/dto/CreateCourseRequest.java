package com.springsecurity.springsecurity.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCourseRequest {
    private String title;
    private String description;
    private Double price;
    private LocalDate releaseDate;
    private boolean available;
    private Long categoryId;
    private Long subCategoryId;
}
