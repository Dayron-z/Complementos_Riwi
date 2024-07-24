package com.example.demo.infrastructure.service;

import com.example.demo.api.dto.ClassRequest;
import com.example.demo.api.dto.ClassResponse;
import com.example.demo.domain.entities.ClassEntity;
import com.example.demo.domain.repository.ClassRepository;
import com.example.demo.infrastructure.mappers.ClassMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{
    @Autowired
    private final ClassRepository classRepository;
    @Autowired
    private final ClassMapper classMapper;



    @Override
    public List<ClassEntity> findAll() {
        return classRepository.findAll();
    }

    @Override
    public ClassResponse findById(Long id) {
        return classMapper.entityToResponse(classRepository.findById(id).orElseThrow());
    }

    @Override
    public ClassResponse save(ClassRequest classRequest) {
        ClassEntity classEntity = this.classMapper.requestToEntity(classRequest);
        return this.classMapper.entityToResponse(this.classRepository.save(classEntity));
    }

    @Override
    public ClassEntity update(Long id, ClassRequest entity) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
