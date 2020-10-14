package com.glossary.controller;

import java.util.List;

import com.glossary.domain.Category;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponse {
    List<Category> categoryList;
    Category category;
    Integer categoryId;
}
