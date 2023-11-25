package com.example.backend_.service;

import com.example.backend_.model.Payment;
import com.example.backend_.model.Project;
import com.example.backend_.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project add(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project update(Project project) {
        return projectRepository.save(project);
    }

    @Override
    @Transactional
    public Optional<List<Payment>> getPayments(Long id) {
        return projectRepository.findById(id).map(Project::getPayments).map(List::copyOf);
    }

    @Override
    public Optional<Project> getByName(String name) {
        return Optional.empty();
    }
}