package com.example.autocine.controller;

import com.example.autocine.model.Funcion;
import com.example.autocine.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funciones")
public class FuncionRestController {

    @Autowired
    private FuncionService funcionService;

    // GET: Listar todas las funciones
    @GetMapping
    public List<Funcion> listar() {
        return funcionService.listarTodas();
    }

    // GET: Buscar función por ID
    @GetMapping("/{id}")
    public ResponseEntity<Funcion> buscarPorId(@PathVariable Long id) {
        Funcion funcion = funcionService.obtenerPorId(id);
        return funcion != null ? ResponseEntity.ok(funcion) : ResponseEntity.notFound().build();
    }

    // POST: Registrar una nueva función
    @PostMapping
    public Funcion guardar(@RequestBody Funcion funcion) {
        return funcionService.guardar(funcion);
    }

    // PUT: Actualizar una función existente
    @PutMapping("/{id}")
    public ResponseEntity<Funcion> actualizar(@PathVariable Long id, @RequestBody Funcion funcionDetails) {
        Funcion actualizada = funcionService.actualizar(id, funcionDetails);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar una función por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = funcionService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}