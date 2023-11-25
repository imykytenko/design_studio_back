package com.example.backend_.service;

import com.example.backend_.model.Interior;

import java.util.List;
import java.util.Optional;

public interface InteriorService {
    Interior add(Interior interior);

    Optional<Interior> findById(Long id);

    List<Interior> findAll();

    void deleteById(Long id);

    Interior update(Interior interior);
}
