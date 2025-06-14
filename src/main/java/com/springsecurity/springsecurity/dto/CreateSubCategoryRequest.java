package com.springsecurity.springsecurity.dto;

import lombok.Data;

@Data
public class CreateSubCategoryRequest {
    private String name;
    private Long categoryId;
}
