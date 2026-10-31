package com.example.autocine.controller;

import com.example.autocine.model.Sala;
import com.example.autocine.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<Sala> listar() {
        return salaService.listarTodas();
    }

    @PostMapping
    public Sala guardar(@RequestBody Sala sala) {
        return salaService.guardar(sala);
    }
}