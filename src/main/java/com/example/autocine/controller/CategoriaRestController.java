package com.example.autocine.controller;

import com.example.autocine.model.Categoria;
import com.example.autocine.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaRestController {

    @Autowired
    private CategoriaService categoriaService;

    // GET: Listar todas las categorías
    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodas();
    }

    // GET: Buscar categoría por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Long id) {
        Categoria categoria = categoriaService.obtenerPorId(id);
        return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
    }

    // POST: Registrar una nueva categoría
    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }

    // PUT: Actualizar una categoría existente
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
        Categoria actualizada = categoriaService.actualizar(id, categoriaDetails);
        return actualizada != null ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // DELETE: Eliminar una categoría por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = categoriaService.eliminar(id);
        return eliminado ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}