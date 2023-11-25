package com.example.backend_.controller.mapper;

import com.example.backend_.controller.dto.client.ClientCreationDto;
import com.example.backend_.controller.dto.client.ClientDto;
import com.example.backend_.controller.dto.client.ClientUpdateDto;
import com.example.backend_.model.Client;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface ClientMapper {
    ClientDto toDto(Client client);

    Client toEntity(ClientCreationDto clientDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Client partialUpdate(ClientUpdateDto clientDto, @MappingTarget Client client);
}
