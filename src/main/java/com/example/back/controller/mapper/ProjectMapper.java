package com.example.backend_.controller.mapper;

import com.example.backend_.controller.dto.project.ProjectCreationDto;
import com.example.backend_.controller.dto.project.ProjectDto;
import com.example.backend_.controller.dto.project.ProjectUpdateDto;
import com.example.backend_.model.Project;
import org.mapstruct.*;

@Mapper
public interface ProjectMapper {
    @Mapping(target = "startDate", source = "startDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "endDate", source = "endDate", dateFormat = "dd-MM-yyyy")
    ProjectDto toDto(Project project);

    Project toEntity(ProjectCreationDto projectDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectUpdateDto projectDto, @MappingTarget Project project);
}
