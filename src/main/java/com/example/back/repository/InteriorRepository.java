package com.example.backend_.repository;

import com.example.backend_.model.Interior;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorRepository extends JpaRepository<Interior, Long> {
}
