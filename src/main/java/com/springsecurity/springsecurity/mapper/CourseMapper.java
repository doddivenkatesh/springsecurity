package com.springsecurity.springsecurity.mapper;

import com.springsecurity.springsecurity.dto.CourseDTO;
import com.springsecurity.springsecurity.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "subCategory.id", target = "subCategoryId")
    CourseDTO toDTO(Course course);

    @Mapping(source = "categoryId", target = "category.id")
    @Mapping(source = "subCategoryId", target = "subCategory.id")
    Course toEntity(CourseDTO dto);
}
