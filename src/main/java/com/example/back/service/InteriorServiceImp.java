package com.example.backend_.service;

import com.example.backend_.model.Interior;
import com.example.backend_.repository.InteriorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InteriorServiceImp implements InteriorService {

    private final InteriorRepository interiorRepository;

    @Override
    public Interior add(Interior interior) {
        return interiorRepository.save(interior);
    }

    @Override
    public Optional<Interior> findById(Long id) {
        return interiorRepository.findById(id);
    }

    @Override
    public List<Interior> findAll() {
        return interiorRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        interiorRepository.deleteById(id);
    }

    @Override
    public Interior update(Interior interior) {
        return interiorRepository.save(interior);
    }
}
