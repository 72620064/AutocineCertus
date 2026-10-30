package com.example.autocine.controller;

import com.example.autocine.model.Pelicula;
import com.example.autocine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    // Endpoint GET para listar todas las películas de la base de datos
    @GetMapping
    public List<Pelicula> listar() {
        return peliculaService.listarTodas();
    }

    // Endpoint POST para registrar una nueva película
    @PostMapping
    public Pelicula guardar(@RequestBody Pelicula pelicula) {
        return peliculaService.guardar(pelicula);
    }
}