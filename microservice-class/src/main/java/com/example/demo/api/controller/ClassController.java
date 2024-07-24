package com.example.demo.api.controller;

import com.example.demo.api.dto.ClassRequest;
import com.example.demo.domain.entities.ClassEntity;
import com.example.demo.infrastructure.service.IClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/class")
public class ClassController {
    @Autowired
    private IClassService classService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody ClassRequest classRequest){
        this.classService.save(classRequest);
    }

    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(classService.findById(id));
    }



}
