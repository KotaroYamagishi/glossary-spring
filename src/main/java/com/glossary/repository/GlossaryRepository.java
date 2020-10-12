package com.glossary.repository;

import java.util.List;

import com.glossary.domain.Glossary;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GlossaryRepository {
    
    List<Glossary> findAll();
    List<Glossary> findByName(@Param("name") String name);
    Glossary findById(@Param("id") Integer id);
    void insert(@Param("glossary") Glossary glossary);
    void update(@Param("glossary") Glossary glossary);
    void delete(Integer id);
}
