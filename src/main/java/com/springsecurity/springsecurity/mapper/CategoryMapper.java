package com.springsecurity.springsecurity.mapper;

import com.springsecurity.springsecurity.dto.CategoryDTO;
import com.springsecurity.springsecurity.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO dto);
}
