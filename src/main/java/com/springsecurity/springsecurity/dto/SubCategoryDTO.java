package com.springsecurity.springsecurity.dto;

import lombok.Data;

@Data
public class SubCategoryDTO {
    private Long id;
    private String name;
    private Long categoryId;
    private String categoryName;
}
