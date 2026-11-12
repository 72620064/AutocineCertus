package com.example.autocine.controller;

import com.example.autocine.model.Sala;
import com.example.autocine.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaRestController {

    @Autowired
    private SalaService salaService;

    // GET: Listar todas las salas
    @GetMapping
    public List<Sala> listar() {
        return salaService.listarTodas();
    }

    // GET: Buscar sala por ID
    @GetMapping("/{id}")
    public ResponseEntity<Sala> buscarPorId(@PathVariable Long id) {
        Sala sala = salaService.obtenerPorId(id);
        return sala != null ? ResponseEntity.ok(sala) : ResponseEntity.notFound().build();
    }

    // POST: Registrar una nueva sala
    @PostMapping
    public Sala guardar(@RequestBody Sala sala) {
        return salaService.guardar(sala);
    }

    // PUT: Actualizar una sala existente
    @PutMapping("/{id}")
    public ResponseEntity<Sala> actualizar(@PathVariable Long id, @RequestBody Sala salaDetails) {
        Sala actualizada = salaService.actualizar(id, salaDetails);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar una sala por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = salaService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}