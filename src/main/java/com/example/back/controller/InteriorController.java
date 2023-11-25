package com.example.backend_.controller;

import com.example.backend_.controller.dto.interior.InteriorCreationDto;
import com.example.backend_.controller.dto.interior.InteriorDto;
import com.example.backend_.controller.dto.interior.InteriorUpdateDto;
import com.example.backend_.controller.mapper.InteriorMapper;
import com.example.backend_.service.InteriorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RequestMapping("/interiors")
public class InteriorController {

    private final InteriorService interiorService;
    private final InteriorMapper interiorMapper;

    @PostMapping("/add")
    public ResponseEntity<InteriorDto> add(@RequestBody InteriorCreationDto interiorDto) {
        var interior = interiorService.add(interiorMapper.toEntity(interiorDto));
        return new ResponseEntity<>(interiorMapper.toDto(interior), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteriorDto> findById(@PathVariable Long id) {
        return ResponseEntity.of(interiorService.findById(id).map(interiorMapper::toDto));
    }

    @GetMapping
    public List<InteriorDto> findAll() {
        return interiorService.findAll().stream().map(interiorMapper::toDto).toList();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<InteriorDto> update(@RequestBody InteriorUpdateDto interiorDto, @PathVariable Long id) {
        return ResponseEntity.of(interiorService.findById(id)
                .map(interior -> interiorMapper.partialUpdate(interiorDto, interior))
                .map(interiorService::update)
                .map(interiorMapper::toDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        interiorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
