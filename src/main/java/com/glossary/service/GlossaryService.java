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

    public List<Glossary> findAll(String userId){
        return glossaryRepository.findAll(userId);
    }

    public List<Glossary> findByName(String name,String userId){
        return glossaryRepository.findByName(name,userId);
    }

    public List<Glossary> findByCategoryId(Integer id){
        return glossaryRepository.findByCategoryId(id);
    }

    public Glossary findById(Integer id,String userId){
        return glossaryRepository.findById(id,userId);
    }

    public Integer insert(GlossaryAddRequest glossaryAddRequest){
        Glossary glossary =new Glossary();
        glossary.setId(glossaryAddRequest.getId());
        glossary.setName(glossaryAddRequest.getName());
        glossary.setDescription(glossaryAddRequest.getDescription());
        glossary.setUserId(glossaryAddRequest.getUserId());
        glossaryRepository.insertGlossary(glossary);
        Glossary insertGlossary=glossaryRepository.findByInsertId(glossaryAddRequest.getUserId());
        return insertGlossary.getId();
    }

    public void update(GlossaryAddRequest glossaryAddRequest){
        Glossary glossary =new Glossary();
        glossary.setId(glossaryAddRequest.getId());
        glossary.setName(glossaryAddRequest.getName());
        glossary.setDescription(glossaryAddRequest.getDescription());
        glossary.setUserId(glossaryAddRequest.getUserId());
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
