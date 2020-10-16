package com.glossary.repository;

import java.util.List;

import com.glossary.domain.Category;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryRepository {
    List<Category> findAll(String userId);
    Category findById(Integer id);
    Category findByName(@Param("category") Category category);
    void insert(@Param("category")Category category);
    void update(@Param("category") Category category);
    void delete(Integer id);
}
