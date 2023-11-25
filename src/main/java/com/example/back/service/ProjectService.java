package com.example.backend_.service;

import com.example.backend_.model.Payment;
import com.example.backend_.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project add(Project project);

    Optional<Project> findById(Long id);

    List<Project> findAll();

    void delete(Long id);

    Project update(Project project);

    Optional<List<Payment>> getPayments(Long id);

    Optional<Project> getByName(String name);
}
