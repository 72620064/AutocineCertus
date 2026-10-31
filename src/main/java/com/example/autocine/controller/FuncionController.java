package com.example.autocine.controller;

import com.example.autocine.model.Funcion;
import com.example.autocine.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funciones")
public class FuncionController {

    @Autowired
    private FuncionService funcionService;

    @GetMapping
    public List<Funcion> listar() {
        return funcionService.listarTodas();
    }

    @PostMapping
    public Funcion guardar(@RequestBody Funcion funcion) {
        return funcionService.guardar(funcion);
    }
}