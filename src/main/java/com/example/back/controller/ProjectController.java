package com.example.backend_.controller;

import com.example.backend_.controller.dto.project.ProjectCreationDto;
import com.example.backend_.controller.dto.project.ProjectDto;
import com.example.backend_.controller.dto.project.ProjectUpdateDto;
import com.example.backend_.controller.mapper.ProjectMapper;
import com.example.backend_.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;
    private final ProjectMapper projectMapper;

    @PostMapping("/add")
    public ResponseEntity<ProjectDto> add(@RequestBody ProjectCreationDto projectDto) {
        var project = projectService.add(projectMapper.toEntity(projectDto));
        return new ResponseEntity<>(projectMapper.toDto(project), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> findById(@PathVariable Long id) {
        return ResponseEntity.of(projectService.findById(id).map(projectMapper::toDto));
    }

    @GetMapping
    public List<ProjectDto> findAll() {
        return projectService.findAll().stream().map(projectMapper::toDto).toList();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectDto> update(@RequestBody ProjectUpdateDto projectDto,
                                             @PathVariable Long id) {
        return ResponseEntity.of(projectService.findById(id)
                .map(project -> projectMapper.partialUpdate(projectDto, project))
                .map(projectService::update)
                .map(projectMapper::toDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
