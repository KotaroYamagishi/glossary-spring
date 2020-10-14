package com.glossary.controller;

import java.util.List;

import com.glossary.domain.Category;
import com.glossary.form.CategoryAddRequest;
import com.glossary.service.CategoryService;
import com.glossary.service.GlossaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GlossaryService glossaryService;

    @GetMapping("/category")
    public ResponseEntity<CategoryResponse> findAll(){
        List<Category> categoryList= categoryService.findAll();
        CategoryResponse categoryResponse= CategoryResponse.builder().categoryList(categoryList).build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Integer id){
        Category category= categoryService.findById(id);
        CategoryResponse categoryResponse= CategoryResponse.builder().category(category).build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/category/insert")
    public ResponseEntity<CategoryResponse> insert(@RequestBody CategoryAddRequest categoryAddRequest){
        Integer categoryId=categoryService.insert(categoryAddRequest.getName());
        System.out.println(categoryId);
        CategoryResponse categoryResponse=CategoryResponse.builder().categoryId(categoryId).build();
        return new ResponseEntity<>(categoryResponse,HttpStatus.CREATED);
    }

    @PostMapping("/category/update")
    public ResponseEntity<HttpStatus> update(@RequestBody CategoryAddRequest categoryAddRequest){
        categoryService.update(categoryAddRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Integer id){
        categoryService.delete(id);
        glossaryService.deleteCategoryId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
