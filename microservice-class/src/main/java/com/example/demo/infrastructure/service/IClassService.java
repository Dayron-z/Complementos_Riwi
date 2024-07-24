package com.example.demo.infrastructure.service;

import com.example.demo.api.dto.ClassRequest;
import com.example.demo.api.dto.ClassResponse;
import com.example.demo.domain.entities.ClassEntity;
import com.example.demo.utils.enums.SortType;
import org.springframework.data.domain.Page;

public interface IClassService {
    Page<ClassResponse> findAll(int page, int size, SortType sortType);
    ClassResponse findById(Long id);
    ClassResponse save(ClassRequest classRequest);
    ClassResponse update(Long id, ClassRequest classRequest);
    void deleteById(Long id);
}
