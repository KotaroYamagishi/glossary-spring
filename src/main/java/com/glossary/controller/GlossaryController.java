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

    @GetMapping("/{userId}")
    public ResponseEntity<GlossaryResponse> findAll(@PathVariable("userId") String userId) {
        List<Glossary> glossaryList = glossaryService.findAll(userId);
        GlossaryResponse glossaryResponse = GlossaryResponse.builder().glossaryList(glossaryList).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @GetMapping("/{userId}/{id}")
    public ResponseEntity<GlossaryResponse> findById(@PathVariable("userId") String userId,@PathVariable("id") Integer id) {
        Glossary glossary = glossaryService.findById(id,userId);
        GlossaryResponse glossaryResponse = GlossaryResponse.builder().glossary(glossary).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @GetMapping("/cate/{id}")
    public ResponseEntity<GlossaryResponse> finByCategoryId(@PathVariable("id") Integer id){
        List<Glossary> glossaryList=glossaryService.findByCategoryId(id);
        GlossaryResponse glossaryResponse=GlossaryResponse.builder().glossaryList(glossaryList).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @GetMapping("{userId}/search/{name}")
    public ResponseEntity<GlossaryResponse> findByName(@PathVariable("userId") String userId,@PathVariable("name") String name){
        List<Glossary> glossaryList=glossaryService.findByName(name,userId);
        GlossaryResponse glossaryResponse=GlossaryResponse.builder().glossaryList(glossaryList).build();
        return new ResponseEntity<>(glossaryResponse, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<GlossaryResponse> addGlossary(@RequestBody GlossaryAddRequest glossaryAddRequest) {
        System.out.println(glossaryAddRequest);
        Integer id=glossaryService.insert(glossaryAddRequest);
        System.out.println(id);
        GlossaryResponse response=GlossaryResponse.builder().glossaryId(id).build();
        return new ResponseEntity<>(response,HttpStatus.CREATED);
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
