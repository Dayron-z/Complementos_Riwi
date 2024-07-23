package com.example.demo.service;

import com.example.demo.entities.ClassEntity;
import com.example.demo.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{
    private final ClassRepository classRepository;


    @Override
    public List<ClassEntity> findAll() {
        return classRepository.findAll();
    }

    @Override
    public ClassEntity findById(Long id) {
        return classRepository.findById(id).orElseThrow();
    }

    @Override
    public ClassEntity save(ClassEntity entity) {
        return classRepository.save(entity);
    }

    @Override
    public ClassEntity update(Long id, ClassEntity entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
