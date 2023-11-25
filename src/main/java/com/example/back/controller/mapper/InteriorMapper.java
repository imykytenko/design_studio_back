package com.example.backend_.controller.mapper;

import com.example.backend_.controller.dto.interior.InteriorCreationDto;
import com.example.backend_.controller.dto.interior.InteriorDto;
import com.example.backend_.controller.dto.interior.InteriorUpdateDto;
import com.example.backend_.model.Interior;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface InteriorMapper {
    InteriorDto toDto(Interior interior);

    Interior toEntity(InteriorCreationDto interiorDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Interior partialUpdate(InteriorUpdateDto interiorDto, @MappingTarget Interior interior);
}
