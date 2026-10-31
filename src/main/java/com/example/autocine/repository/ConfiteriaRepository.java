package com.example.autocine.repository;

import com.example.autocine.model.Confiteria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiteriaRepository extends JpaRepository<Confiteria, Long> {
}