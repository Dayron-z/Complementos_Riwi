package com.example.demo.service;

import com.example.demo.entities.ClassEntity;

import java.util.List;

public interface IClassService {
    List<ClassEntity> findAll();
    ClassEntity findById(Long id);
    ClassEntity save(ClassEntity entity);
    ClassEntity update(Long id, ClassEntity entity);
    void deleteById(Long id);
}
