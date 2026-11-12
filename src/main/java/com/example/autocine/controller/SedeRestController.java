package com.example.autocine.controller;

import com.example.autocine.model.Sede;
import com.example.autocine.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedeRestController {

    @Autowired
    private SedeService sedeService;

    // GET: Listar todas las sedes
    @GetMapping
    public List<Sede> listar() {
        return sedeService.listarTodas();
    }

    // GET: Buscar sede por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sede> buscarPorId(@PathVariable Long id) {
        Sede sede = sedeService.obtenerPorId(id);
        return sede != null ? ResponseEntity.ok(sede) : ResponseEntity.notFound().build();
    }

    // POST: Registrar una nueva sede
    @PostMapping
    public Sede guardar(@RequestBody Sede sede) {
        return sedeService.guardar(sede);
    }

    // PUT: Actualizar una sede existente
    @PutMapping("/{id}")
    public ResponseEntity<Sede> actualizar(@PathVariable Long id, @RequestBody Sede sedeDetails) {
        Sede actualizada = sedeService.actualizar(id, sedeDetails);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar una sede por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = sedeService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}