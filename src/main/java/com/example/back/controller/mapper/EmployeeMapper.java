package com.example.backend_.controller.mapper;

import com.example.backend_.controller.dto.employee.EmployeeCreationDto;
import com.example.backend_.controller.dto.employee.EmployeeDto;
import com.example.backend_.controller.dto.employee.EmployeeUpdateDto;
import com.example.backend_.model.Employee;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface EmployeeMapper {
    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeCreationDto employeeDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Employee partialUpdate(EmployeeUpdateDto employeeDto, @MappingTarget Employee employee);
}
