package com.glossary.service;

import java.util.List;

import com.glossary.domain.Category;
import com.glossary.form.CategoryAddRequest;
import com.glossary.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(String userId){
        return categoryRepository.findAll(userId);
    }
    public Category findById(Integer id){
        return categoryRepository.findById(id);
    }
    public Integer insert(CategoryAddRequest categoryWAddRequest){
        Category category =new Category();
        category.setName(categoryWAddRequest.getName());
        category.setUserId(categoryWAddRequest.getUserId());
        categoryRepository.insert(category);
        return categoryRepository.findByName(category).getId();
    }
    public void update(CategoryAddRequest categoryAddRequest){
        Category category=new Category();
        category.setId(categoryAddRequest.getId());
        category.setName(categoryAddRequest.getName());
        categoryRepository.update(category);
    }
    public void delete(Integer id){
        categoryRepository.delete(id);
    }
}
