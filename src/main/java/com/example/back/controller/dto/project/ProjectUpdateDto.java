package com.example.backend_.controller.dto.project;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProjectUpdateDto {
    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private String budget;
}
