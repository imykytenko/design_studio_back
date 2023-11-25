package com.example.backend_.controller.dto.client;

import lombok.Data;

@Data
public class ClientCreationDto {
    private String name;

    private String surname;

    private String email;

    private String phone;
}
