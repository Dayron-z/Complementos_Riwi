package com.example.demo.infrastructure.service;

import com.example.demo.api.dto.ClassRequest;
import com.example.demo.api.dto.ClassResponse;
import com.example.demo.domain.entities.ClassEntity;

import java.util.List;

public interface IClassService {
    List<ClassEntity> findAll();
    ClassResponse findById(Long id);
    ClassResponse save(ClassRequest classRequest);
    ClassEntity update(Long id, ClassRequest classRequest);
    void deleteById(Long id);
}
