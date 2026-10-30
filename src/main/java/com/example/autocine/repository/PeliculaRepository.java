package com.example.autocine.repository;

import com.example.autocine.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    // JpaRepository ya incluye métodos listos como findAll(), save(), findById(), deleteById(), etc.
}