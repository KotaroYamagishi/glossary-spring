package com.glossary.repository;

import com.glossary.domain.User;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    
    User findByUserId(String uid);
    void insert(String uid);
}
