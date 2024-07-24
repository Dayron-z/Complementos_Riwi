package com.example.demo.infrastructure.mappers;


import com.example.demo.api.dto.ClassRequest;
import com.example.demo.api.dto.ClassResponse;
import com.example.demo.domain.entities.ClassEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClassMapper {
    ClassEntity requestToEntity(ClassRequest classRequest);
    ClassResponse entityToResponse(ClassEntity classEntity);
}
