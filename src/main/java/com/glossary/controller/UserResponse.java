package com.glossary.controller;

import com.glossary.domain.User;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {
    private User user;
}
