package com.example.autocine.service;

import com.example.autocine.model.Pelicula;
import com.example.autocine.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> listarTodas() {
        return peliculaRepository.findAll();
    }

    public Pelicula obtenerPorId(Long id) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        return pelicula.orElse(null);
    }

    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public Pelicula actualizar(Long id, Pelicula peliculaDetails) {
        Optional<Pelicula> peliculaOptional = peliculaRepository.findById(id);
        if (peliculaOptional.isPresent()) {
            Pelicula peliculaExistente = peliculaOptional.get();
            
            peliculaExistente.setTitulo(peliculaDetails.getTitulo());
            peliculaExistente.setGenero(peliculaDetails.getGenero());
            peliculaExistente.setDuracionMinutos(peliculaDetails.getDuracionMinutos());
            peliculaExistente.setSinopsis(peliculaDetails.getSinopsis());
            peliculaExistente.setDirector(peliculaDetails.getDirector());
            peliculaExistente.setImagenUrl(peliculaDetails.getImagenUrl());
            
            return peliculaRepository.save(peliculaExistente);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}