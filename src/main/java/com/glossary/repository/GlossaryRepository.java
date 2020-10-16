package com.glossary.repository;

import java.util.List;

import com.glossary.domain.Glossary;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GlossaryRepository {
    
    List<Glossary> findAll(String userId);
    List<Glossary> findByName(@Param("name") String name,@Param("userId") String userId);
    List<Glossary> findByCategoryId(Integer categoryId);
    Glossary findById(@Param("id") Integer id,@Param("userId") String userId);
    Glossary findByInsertId(String userId);
    void insertGlossary(@Param("glossary") Glossary glossary);
    void update(@Param("glossary") Glossary glossary);
    void deleteCategoryId(Integer categoryId);
    void delete(Integer id);
}
