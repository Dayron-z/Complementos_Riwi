package com.example.demo.controller;

import com.example.demo.entities.ClassEntity;
import com.example.demo.service.IClassService;
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
    public void saveStudent(@RequestBody ClassEntity classEntity){
        this.classService.save(classEntity);
    }

    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(classService.findById(id));
    }



}
