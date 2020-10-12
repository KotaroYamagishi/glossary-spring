package com.glossary.repository;

import com.glossary.domain.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    
    User findByUserId(Integer uid);
    void insert(Integer uid);
}
