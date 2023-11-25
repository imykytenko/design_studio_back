package com.example.backend_.controller.dto.employee;

import lombok.Data;

@Data
public class EmployeeUpdateDto {
    private String position;

    private String name;

    private String surname;

    private String email;

    private String phone;
}
