package com.glossary.form;

import lombok.Data;

@Data
public class GlossaryAddRequest {
    private Integer id;
    private String name;
    private String description;
}
