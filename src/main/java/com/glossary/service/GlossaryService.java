package com.glossary.service;

import java.util.List;

import com.glossary.domain.Glossary;
import com.glossary.form.GlossaryAddRequest;
import com.glossary.repository.GlossaryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GlossaryService {
    
    @Autowired
    private GlossaryRepository glossaryRepository;

    public List<Glossary> findAll(){
        return glossaryRepository.findAll();
    }

    public List<Glossary> findByName(String name){
        return glossaryRepository.findByName(name);
    }

    public List<Glossary> findByCategoryId(Integer id){
        return glossaryRepository.findByCategoryId(id);
    }

    public Glossary findById(Integer id){
        return glossaryRepository.findById(id);
    }

    public void insert(GlossaryAddRequest glossaryAddRequest){
        Glossary glossary =new Glossary();
        glossary.setId(glossaryAddRequest.getId());
        glossary.setName(glossaryAddRequest.getName());
        glossary.setDescription(glossaryAddRequest.getDescription());
        glossaryRepository.insert(glossary);
    }

    public void update(GlossaryAddRequest glossaryAddRequest){
        Glossary glossary =new Glossary();
        glossary.setId(glossaryAddRequest.getId());
        glossary.setName(glossaryAddRequest.getName());
        glossary.setDescription(glossaryAddRequest.getDescription());
        glossary.setCategoryId(glossaryAddRequest.getCategoryId());
        glossaryRepository.update(glossary);
    }

    public void deleteCategoryId(Integer categoryId){
        glossaryRepository.deleteCategoryId(categoryId);
    }

    public void delete(Integer id){
        glossaryRepository.delete(id);
    }
}
