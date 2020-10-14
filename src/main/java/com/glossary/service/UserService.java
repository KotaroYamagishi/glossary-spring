package com.glossary.service;

import com.glossary.domain.User;
import com.glossary.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public User findByUserId(String uid){
        return userRepository.findByUserId(uid);
    }

    public void insert(String uid){
        userRepository.insert(uid);
    }
}
