package com.example.backend_.controller.dto.employee;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;

    private String position;

    private String name;

    private String surname;

    private String email;

    private String phone;
}
