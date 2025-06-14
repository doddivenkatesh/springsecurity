package com.springsecurity.springsecurity.mapper;

import com.springsecurity.springsecurity.dto.SubCategoryDTO;
import com.springsecurity.springsecurity.entity.SubCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubCategoryMapper {

    @Mapping(source = "category.id", target = "categoryId")
    SubCategoryDTO toDTO(SubCategory subCategory);

    @Mapping(source = "categoryId", target = "category.id")
    SubCategory toEntity(SubCategoryDTO dto);
}
