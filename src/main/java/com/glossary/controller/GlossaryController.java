package com.glossary.controller;

import java.util.List;

import com.glossary.domain.Glossary;
import com.glossary.form.GlossaryAddRequest;
import com.glossary.service.GlossaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GlossaryController {

    @Autowired
    private GlossaryService glossaryService;

    @GetMapping("/")
    public ResponseEntity<GlossaryResponse> findAll() {
        List<Glossary> glossaryList = glossaryService.findAll();
        GlossaryResponse glossaryResponse = GlossaryResponse.builder().glossaryList(glossaryList).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlossaryResponse> findById(@PathVariable("id") Integer id) {
        Glossary glossary = glossaryService.findById(id);
        GlossaryResponse glossaryResponse = GlossaryResponse.builder().glossary(glossary).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @GetMapping("/cate/{id}")
    public ResponseEntity<GlossaryResponse> finByCategoryId(@PathVariable("id") Integer id){
        List<Glossary> glossaryList=glossaryService.findByCategoryId(id);
        GlossaryResponse glossaryResponse=GlossaryResponse.builder().glossaryList(glossaryList).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<GlossaryResponse> findByName(@PathVariable("name") String name){
        List<Glossary> glossaryList=glossaryService.findByName(name);
        GlossaryResponse glossaryResponse=GlossaryResponse.builder().glossaryList(glossaryList).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> addGlossary(@RequestBody GlossaryAddRequest glossaryAddRequest) {
        System.out.println(glossaryAddRequest);
        glossaryService.insert(glossaryAddRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/edit")
    public ResponseEntity<HttpStatus> editGlossary(@RequestBody GlossaryAddRequest glossaryAddRequest) {
        System.out.println(glossaryAddRequest);
        glossaryService.update(glossaryAddRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGlossary(@PathVariable Integer id) {
        glossaryService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
