package com.glossary.repository;

import java.util.List;

import com.glossary.domain.Category;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CategoryRepository {
    List<Category> findAll();
    Category findById(Integer id);
    Category findByName(String name);
    void insert(String name);
    void update(@Param("category") Category category);
    void delete(Integer id);
}
