package com.glossary.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Glossary {
    private Integer id;
    private String name;
    private String description;
    private Date createAt;
}
