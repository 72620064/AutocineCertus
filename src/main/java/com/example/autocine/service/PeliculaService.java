package com.example.autocine.service;

import com.example.autocine.model.Pelicula;
import com.example.autocine.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    // Método para listar todas las películas de la base de datos
    public List<Pelicula> listarTodas() {
        return peliculaRepository.findAll();
    }

    // Método para guardar una nueva película
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }
}