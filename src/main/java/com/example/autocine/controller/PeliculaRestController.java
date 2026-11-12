package com.example.autocine.controller;

import com.example.autocine.model.Pelicula;
import com.example.autocine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaRestController {

    @Autowired
    private PeliculaService peliculaService;

    // Endpoint GET para listar todas las películas de la base de datos
    @GetMapping
    public List<Pelicula> listar() {
        return peliculaService.listarTodas();
    }

    // Endpoint GET para buscar una película por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
        Pelicula pelicula = peliculaService.obtenerPorId(id);
        return pelicula != null ? ResponseEntity.ok(pelicula) : ResponseEntity.notFound().build();
    }

    // Endpoint POST para registrar una nueva película
    @PostMapping
    public Pelicula guardar(@RequestBody Pelicula pelicula) {
        return peliculaService.guardar(pelicula);
    }

    // Endpoint PUT para actualizar una película existente
    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id, @RequestBody Pelicula peliculaDetails) {
        Pelicula actualizada = peliculaService.actualizar(id, peliculaDetails);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // Endpoint DELETE para eliminar una película por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = peliculaService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}