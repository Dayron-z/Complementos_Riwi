package com.example.demo.api.controller;

import com.example.demo.api.dto.ClassRequest;
import com.example.demo.api.dto.ClassResponse;
import com.example.demo.domain.entities.ClassEntity;
import com.example.demo.infrastructure.service.IClassService;
import com.example.demo.utils.enums.SortType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("api/class")
public class ClassController {
    @Autowired
    private IClassService classService;



    @GetMapping("/{id}")
    public ResponseEntity<ClassResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(classService.findById(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClassResponse>>getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "8") int size, @RequestHeader(required = false) SortType sortType){

        if (Objects.isNull(sortType)){
            sortType = SortType.NONE;
        }

        return ResponseEntity.ok(this.classService.findAll(page - 1, size, sortType));
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody ClassRequest classRequest){
        this.classService.save(classRequest);
    }



}
