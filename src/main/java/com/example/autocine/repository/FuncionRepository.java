package com.example.autocine.repository;

import com.example.autocine.model.Funcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion, Long> {
}