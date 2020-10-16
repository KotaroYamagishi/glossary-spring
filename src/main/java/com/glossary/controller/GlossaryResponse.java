package com.glossary.controller;

import java.util.List;

import com.glossary.domain.Glossary;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GlossaryResponse {
    private List<Glossary> glossaryList;
    private Glossary glossary;
    private Integer glossaryId;
}
