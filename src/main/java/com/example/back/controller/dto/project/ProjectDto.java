package com.example.backend_.controller.dto.project;

import lombok.Data;

@Data
public class ProjectDto {
    private Long id;

    private String name;

    private String startDate;

    private String endDate;

    private String description;

    private String budget;
}
