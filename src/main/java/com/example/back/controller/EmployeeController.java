package com.example.backend_.controller;

import com.example.backend_.controller.dto.employee.EmployeeCreationDto;
import com.example.backend_.controller.dto.employee.EmployeeDto;
import com.example.backend_.controller.dto.employee.EmployeeUpdateDto;
import com.example.backend_.controller.mapper.EmployeeMapper;
import com.example.backend_.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> add(@RequestBody EmployeeCreationDto employeeDto) {
        var employee = employeeService.add(employeeMapper.toEntity(employeeDto));
        return new ResponseEntity<>(employeeMapper.toDto(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        return ResponseEntity.of(employeeService.findById(id).map(employeeMapper::toDto));
    }

    @GetMapping
    public List<EmployeeDto> findAll() {
        return employeeService.findAll().stream().map(employeeMapper::toDto).toList();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@RequestBody EmployeeUpdateDto employeeDto, @PathVariable Long id) {
        return ResponseEntity.of(employeeService.findById(id)
                .map(employee -> employeeMapper.partialUpdate(employeeDto, employee))
                .map(employeeService::update)
                .map(employeeMapper::toDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
