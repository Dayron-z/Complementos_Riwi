package com.example.demo.infrastructure.service;

import com.example.demo.api.dto.ClassRequest;
import com.example.demo.api.dto.ClassResponse;
import com.example.demo.domain.entities.ClassEntity;
import com.example.demo.domain.repository.ClassRepository;
import com.example.demo.infrastructure.mappers.ClassMapper;
import com.example.demo.utils.enums.SortType;
import com.example.demo.utils.exceptions.BadRequestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassService implements IClassService{
    @Autowired
    private final ClassRepository classRepository;
    @Autowired
    private final ClassMapper classMapper;



    @Override
    public Page<ClassResponse> findAll(int page, int size, SortType sortType) {

        if (page < 0){
            page = 0;
        }

        PageRequest pagination  = null;

        switch (sortType){
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC));
            case DESC -> pagination =  PageRequest.of(page, size, Sort.by(Sort.Direction.DESC));

        }

        return this.classRepository.findAll(pagination).map(classEntity -> this.classMapper.entityToResponse(classEntity));
    }

    @Override
    public ClassResponse findById(Long id) {
        return classMapper.entityToResponse(this.getById(id));
    }

    @Override
    public ClassResponse save(ClassRequest classRequest) {
        ClassEntity classEntity = this.classMapper.requestToEntity(classRequest);
        return this.classMapper.entityToResponse(this.classRepository.save(classEntity));
    }

    @Override
    public ClassResponse update(Long id, ClassRequest entity) {
        ClassEntity classEntity = this.getById(id);
        ClassEntity updatedClass = new ClassEntity();

        updatedClass.setId(classEntity.getId());
        updatedClass.setCreated_at(classEntity.getCreated_at());
        updatedClass.setState(classEntity.getState());
        updatedClass.setName(entity.getName());
        updatedClass.setText(entity.getText());
        return this.classMapper.entityToResponse(this.classRepository.save(updatedClass));
    }

    @Override
    public void deleteById(Long id) {
        ClassEntity classEntity = this.getById(id);
        this.classRepository.delete(classEntity);
    }

    private ClassEntity getById(Long id){
        return this.classRepository.findById(id).orElseThrow(()-> new BadRequestException("The id has no relation to a class"));
    }

}
