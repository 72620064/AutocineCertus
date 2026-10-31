package com.example.autocine.controller;

import com.example.autocine.model.Categoria;
import com.example.autocine.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<Categoria> listar() {
        return categoriaService.listarTodas();
    }

    @PostMapping
    public Categoria guardar(@RequestBody Categoria categoria) {
        return categoriaService.guardar(categoria);
    }
}