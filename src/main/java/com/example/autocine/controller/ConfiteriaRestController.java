package com.example.autocine.controller;

import com.example.autocine.model.Confiteria;
import com.example.autocine.service.ConfiteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/confiteria")
public class ConfiteriaRestController {

    @Autowired
    private ConfiteriaService confiteriaService;

    // GET: Listar todos los productos de confitería
    @GetMapping
    public List<Confiteria> listar() {
        return confiteriaService.listarTodos();
    }

    // GET: Buscar producto de confitería por ID
    @GetMapping("/{id}")
    public ResponseEntity<Confiteria> buscarPorId(@PathVariable Long id) {
        Confiteria confiteria = confiteriaService.obtenerPorId(id);
        return confiteria != null ? ResponseEntity.ok(confiteria) : ResponseEntity.notFound().build();
    }

    // POST: Registrar un nuevo producto de confitería
    @PostMapping
    public Confiteria guardar(@RequestBody Confiteria confiteria) {
        return confiteriaService.guardar(confiteria);
    }

    // PUT: Actualizar un producto de confitería existente
    @PutMapping("/{id}")
    public ResponseEntity<Confiteria> actualizar(@PathVariable Long id, @RequestBody Confiteria confiteriaDetails) {
        Confiteria actualizada = confiteriaService.actualizar(id, confiteriaDetails);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar un producto de confitería por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = confiteriaService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}